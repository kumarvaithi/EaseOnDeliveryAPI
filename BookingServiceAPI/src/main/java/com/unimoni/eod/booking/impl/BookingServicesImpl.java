package com.unimoni.eod.booking.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.unimoni.eod.booking.bean.BookingConfirmRequestBean;
import com.unimoni.eod.booking.bean.BookingConfirmResponseBean;
import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.bean.CommonResponseBean;
import com.unimoni.eod.booking.bean.SMSBean;
import com.unimoni.eod.booking.bean.SMSRequestBean;
import com.unimoni.eod.booking.model.BookingCustomerDetails;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.BookingTxnStatus;
import com.unimoni.eod.booking.model.Customer;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.model.OTPDetails;
import com.unimoni.eod.booking.repo.BookingCustomerDetailsRepositary;
import com.unimoni.eod.booking.repo.BookingHistoryRepositary;
import com.unimoni.eod.booking.repo.BookingTxnRepository;
import com.unimoni.eod.booking.repo.BookingTxnStatusRepository;
import com.unimoni.eod.booking.repo.CustomerRepositary;
import com.unimoni.eod.booking.repo.DeliveryChargesRepository;
import com.unimoni.eod.booking.repo.OTPDetailsRepositary;
import com.unimoni.eod.booking.service.AsyncSMSService;
import com.unimoni.eod.booking.service.BookingService;
import com.unimoni.eod.booking.utils.CommonMethodUtils;
import com.unimoni.eod.booking.utils.DistanceCalculator;


@Service
public class BookingServicesImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServicesImpl.class);

	@Autowired
	CustomerRepositary customerRepositary;

	@Autowired
	BookingTxnRepository bookingTxnRepository;

	@Autowired
	BookingTxnStatusRepository bookingTxnStatusRepository;

	@Autowired
	BookingCustomerDetailsRepositary bookingCustomerDetailsRepositary; 

	@Autowired
	BookingHistoryRepositary bookingHistoryRepository;


	@Autowired
	DeliveryChargesRepository deliveryChrgRepository;

	@Autowired
	OTPDetailsRepositary oTPDetailsRepositary;
	
	@Autowired
	private KafkaTemplate<String, BookingResponseBean> kafkaTemplate;

	private static final String TOPIC = "Kafka_Example_json";

	@Autowired
	DistanceCalculator distanceCalculator;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AsyncSMSService asyncSMSService;
	
	@PostConstruct
	public void init() {
		System.out.println("Booking Service IMPL... Calling...");
	}

	@Override
	public DeliveryCharges findDeliveryCharges(DeliveryCharges deliveryChrg) {
		System.out.println("Coming from bookinservices....!!!");	
		logger.debug("findDeliveryCharges : " + deliveryChrg.getVehicleType());
		double totalDistance = distanceCalculator.distance(32.9697, -96.80322, 29.46786, -98.53506, "M");
		System.out.println("Distance....!!!"+totalDistance);
		//deliveryChrg.setToDistance((int) Math.round(totalDistance));
		deliveryChrg.setToDistance(35);
		Optional<DeliveryCharges> dtChrg = deliveryChrgRepository.findByToDistance((int)Math.round(totalDistance));
		//deliveryChrgRepository.save(entity)

		return deliveryChrg;

	}

	@Override
	@Transactional
	public BookingResponseBean confirmBooking(BookingRequestBean request) {
		BookingResponseBean response = new BookingResponseBean();
		
		List<BookingTxnStatus> bookingStatus = new ArrayList();
		//			Customer customer = null;
		Customer customer = customerRepositary.findByCustomerID(request.getCustomerID());

		BookingTxn bookingTxn = bookingTxnRepository.save(new BookingTxn()
				.setBillAmount(Double.parseDouble(request.getBillAmount()))
				.setBookingDate(LocalDate.now())
				.setCommission(Double.parseDouble(request.getCommsion()))
				.setCreatedAt(LocalDate.now())
				.setCustomerID(request.getCustomerID())
				.setDeliverWhen(request.getDeliverWhen())
				.setDeliveryDate(CommonMethodUtils.convertStringtoDate(request.getDeliveryDate()))
				.setDropLocation(request.getDropLocation())
				.setItemTentativeWeight(Double.parseDouble(request.getItemTentativeWeight()))
				.setItemType(request.getItemType())
				.setPickUpLocation(request.getPickupLocation())
				.setStorePersonContactNo(request.getStorePersonContactNo())
				.setStorePersonName(request.getStorePersonName())
				.setTotalBillAmount(Double.parseDouble(request.getTotalBillAmount()))
				.setVat(Double.parseDouble(request.getVat()))
				.setVehicleID(0)
				.setProviderID(0)
				.setBookingStatus("I")
				.setVehicleType(request.getVehicleType())
				.setPaymentMode(request.getPaymentMode()));

		bookingTxnStatusRepository.save(new BookingTxnStatus()
				.setStatus("I")
				.setBookingTxn(bookingTxn)
				.setModifiedBy(customer.getEmailID())
				.setModifiedAt(LocalDate.now()));

		bookingCustomerDetailsRepositary.save(new BookingCustomerDetails()
				.setAddress(customer.getAddress())
				.setAlternativeMobileNo(customer.getAlternativeMobileNo())
				.setBookingTxn(bookingTxn)
				.setCustomerID(customer.getCustomerID())
				.setEmailID(customer.getEmailID())
				.setMobileNo(customer.getMobileNo())
				.setName(customer.getName()));

		response.setBookingID(bookingTxn.getBookingID());
		
		restTemplate.exchange("http://localhost:8082/kafka/publish/" + bookingTxn.getBookingID(), HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
		}, bookingTxn.getBookingID()).getBody();

		return response;
	}


	@Override
	public List<BookingHistoryBean> bookingHistory(int customerID) {
		System.out.println("I am inside bookingHistoryRepositary implementation" + customerID);
		List<BookingHistoryBean> response = new ArrayList();
		try {
			List<BookingTxn> history = bookingHistoryRepository.findByCustomerID(customerID);

			System.out.println("++++++HISTORY DATA++++++" + history.toString());

			for(int i=0;i<history.size();i++) {
				BookingHistoryBean temp = new BookingHistoryBean();
				
				temp.setBookingID(history.get(i).getBookingID());
				temp.setDeliveryDate(history.get(i).getDeliveryDate());
				temp.setDeliveryPersonContactNo(history.get(i).getStorePersonContactNo());
				temp.setDeliveryPersonName(history.get(i).getStorePersonName());
				temp.setDeliveryProductType(history.get(i).getItemType());
				temp.setTentativeWeight(history.get(i).getItemTentativeWeight());
				temp.setBookingDate(history.get(i).getBookingDate());
				temp.setTotalBillAmount(history.get(i).getTotalBillAmount());
				response.add(temp);
			}
			System.out.println("++++++ Final Response ++++++" + response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public String publishBookingDetail(Long bookingID) {
		//Optional<BookingTxn> bookingDet = bookingTxnRepository.findByBookingID(bookingID);
		BookingResponseBean book = new BookingResponseBean();
		kafkaTemplate.send(TOPIC, book);
		return "Hello booking published";
	}

	@Override
	public BookingResponseBean retrieveBookingsDetails(int bookingID) {
		// TODO Auto-generated method stub
		System.out.println("inside retrieve booking txn");
		BookingTxn bookingTxn = bookingTxnRepository.findByBookingID(bookingID);
		System.out.println("Status is " + bookingTxn.getBookingTxnStatus().get(0).getStatus());
		System.out.println(bookingTxn.toString());


		BookingResponseBean responseBean = new BookingResponseBean();
		responseBean.setBillAmount(bookingTxn.getBillAmount());
		responseBean.setBookingDate(bookingTxn.getBookingDate().toString());
		responseBean.setBookingID(bookingTxn.getBookingID());
		responseBean.setCommsion(bookingTxn.getCommission());
		responseBean.setDeliverWhen(bookingTxn.getDeliverWhen());
		responseBean.setDeliveryDate(bookingTxn.getDeliveryDate().toString());
		responseBean.setDropLocation(bookingTxn.getDropLocation());
		responseBean.setItemTentativeWeight(String.valueOf(bookingTxn.getItemTentativeWeight()));
		responseBean.setItemType(bookingTxn.getItemType());
		responseBean.setPickupLocation(bookingTxn.getPickUpLocation());
		responseBean.setStorePersonContactNo(bookingTxn.getStorePersonContactNo());
		responseBean.setStorePersonName(bookingTxn.getStorePersonName());
		responseBean.setTotalBillAmount(bookingTxn.getTotalBillAmount());
		responseBean.setVehicleType(bookingTxn.getVehicleType());
		responseBean.setBookingStatus(bookingTxn.getBookingStatus());
		
		BookingTxnStatus txnStatus = null;
		List<BookingTxnStatus> txnStatusList = new ArrayList();
		for(int i=0;i<bookingTxn.getBookingTxnStatus().size();i++) {
			txnStatus = new BookingTxnStatus();
			txnStatus.setStatus(bookingTxn.getBookingTxnStatus().get(i).getStatus());
			txnStatus.setModifiedAt(bookingTxn.getBookingTxnStatus().get(i).getModifiedAt());
			txnStatus.setModifiedBy(bookingTxn.getBookingTxnStatus().get(i).getModifiedBy());
			txnStatusList.add(txnStatus);
		}
		responseBean.setBookingTxnStatus(txnStatusList);

		BookingCustomerDetails customerDetails = new BookingCustomerDetails();

		customerDetails.setAddress(bookingTxn.getBookingCustomerDetails().getAddress());
		customerDetails.setAlternativeMobileNo(bookingTxn.getBookingCustomerDetails().getAlternativeMobileNo());
		customerDetails.setCustomerID(bookingTxn.getBookingCustomerDetails().getCustomerID());
		customerDetails.setEmailID(bookingTxn.getBookingCustomerDetails().getEmailID());
		customerDetails.setMobileNo(bookingTxn.getBookingCustomerDetails().getMobileNo());
		customerDetails.setName(bookingTxn.getBookingCustomerDetails().getName());

		responseBean.setBookingCustomerDetails(customerDetails);		
		responseBean.setResultData(new CommonResponseBean()
				.setReponseErrorType("BACKEND")
				.setResponseCode("00")
				.setResponseMessage("SUCCESS"));

		return responseBean;
	}

	@Override
	public BookingConfirmResponseBean orderConfirmation(BookingConfirmRequestBean orderRequest) {
		BookingConfirmResponseBean response = new BookingConfirmResponseBean();
		try {
			if(orderRequest.getBookingID() != 0) {

				BookingTxnStatus bookingStatus = new BookingTxnStatus();
				BookingTxn bookingTxn = bookingTxnRepository.findByBookingID(orderRequest.getBookingID());

				System.out.println("Booking Status is " + orderRequest.getBookingStatus());
				List<BookingTxnStatus> bookingStatusList = new ArrayList<>();
				bookingStatus.setStatus(orderRequest.getBookingStatus());
				bookingStatus.setModifiedAt(LocalDate.now());
				bookingStatus.setModifiedBy("SYSTEM");
				bookingStatus.setBookingTxn(bookingTxn);
				bookingStatusList.add(bookingStatus);


				bookingTxn.setProviderID(orderRequest.getProviderID());
				bookingTxn.setVehicleID(orderRequest.getProviderVehicleDetailsID());
				bookingTxn.setBookingStatus(orderRequest.getBookingStatus());
				bookingTxn.setBookingTxnStatus(bookingStatusList);

				bookingTxnRepository.save(bookingTxn);

				SMSRequestBean smsRequest = new SMSRequestBean();
				CommonMethodUtils common = new CommonMethodUtils();

				int customerOTP = common.generateOTP(4, orderRequest.getBookingID(), "C");
				int storeOTP = common.generateOTP(4, orderRequest.getBookingID(), "S");

				oTPDetailsRepositary.save(new OTPDetails()
			    		  .setBookingID(orderRequest.getBookingID())
			    		  .setGeneratedOn(LocalDate.now())
			    		  .setOtp(storeOTP)
			    		  .setStatus("I")
			    		  .setUserType("S"));
				
				oTPDetailsRepositary.save(new OTPDetails()
			    		  .setBookingID(orderRequest.getBookingID())
			    		  .setGeneratedOn(LocalDate.now())
			    		  .setOtp(customerOTP)
			    		  .setStatus("I")
			    		  .setUserType("C"));
				
				SMSBean stroeSMS = new SMSBean();
				stroeSMS.setSmsMessageContent("Order for " + bookingTxn.getItemType() + " will be picked shortly by EASEONDEVLICERY person, share PIN - " + storeOTP + ". To confirm Pickup");
				stroeSMS.setToMobileNumber(bookingTxn.getStorePersonContactNo());
				

				System.out.println("" + bookingTxn.getStorePersonContactNo());
				System.out.println("" + bookingTxn.getBookingCustomerDetails().getMobileNo());
				
				SMSBean customerSMS = new SMSBean();
				customerSMS .setSmsMessageContent("Order for " + bookingTxn.getItemType() + " will be delivered by EASEONDEVLICERY person, share PIN - " + storeOTP + ". To confirm Delivery");
				customerSMS .setToMobileNumber(bookingTxn.getBookingCustomerDetails().getMobileNo());

				List<SMSBean> smsList = new ArrayList<>();
				smsList.add(stroeSMS);
				smsList.add(customerSMS);
				smsRequest.setSmsBeanList(smsList);

				response.setBookingID(orderRequest.getBookingID());
				response.setProviderID(orderRequest.getProviderID());
				response.setProviderVehicleDetailsID(orderRequest.getProviderVehicleDetailsID());
				response.setBookingStatus(orderRequest.getBookingStatus());
				response.setCommonResponse(new CommonResponseBean()
						.setReponseErrorType("BACKEND")
						.setResponseCode("00")
						.setResponseMessage("SUCCESS"));
				
//				String messageResponse = asyncSMSService.asyncSMS(smsRequest);
//				System.out.println("messageResponse is " + messageResponse);
//				System.out.println("Before Calling SMS Bean");
//				String msgResponse = restTemplate.postForObject("http://localhost:8088/sms/send/", smsRequest ,String.class);
//				System.out.println("SMS Response " + msgResponse);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}


		return response;
	}

	//-------------- Publish the booking information ---------------

	/*@GetMapping("/publish/{booking}")
    public String post(@PathVariable("booking") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public CommonResponseBean verifyPIN(String userType,int bookingID, int pin) {
		OTPDetails otpDetails = oTPDetailsRepositary.findByBookingIDAndOtpAndUserType(bookingID, pin, userType);
		String status = "D";
		CommonResponseBean response = new CommonResponseBean();
		
		if(otpDetails != null) {
			otpDetails.setStatus("V");
			oTPDetailsRepositary.save(otpDetails);
			
			BookingTxn bookingTxn = bookingTxnRepository.findByBookingID(bookingID);
			
			if(userType.equals("S")) {
				status = "P";
			}
			
			List<BookingTxnStatus> bookingTxnStatusList = new ArrayList<>();
			
			BookingTxnStatus bookingTxnStaus = new BookingTxnStatus()
					.setBookingTxn(bookingTxn)
					.setStatus(status)
					.setModifiedAt(LocalDate.now())
					.setModifiedBy("SYSTEM");
			
			bookingTxn.setBookingStatus(status);
			bookingTxnStatusList.add(bookingTxnStaus);
			bookingTxn.setBookingTxnStatus(bookingTxnStatusList);
			bookingTxnRepository.save(bookingTxn);
			
			response.setReponseErrorType("BACKEND");
			response.setResponseCode("00");
			response.setResponseMessage("SUCCESS");
		}else {
			response.setReponseErrorType("BACKEND");
			response.setResponseCode("01");
			response.setResponseMessage("PIN Incorrect ");
		}
		
		return response;
	}
}

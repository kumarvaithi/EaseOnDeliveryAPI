package com.unimoni.eod.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingHistoryResponseBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.bean.BookingResponseListBean;
import com.unimoni.eod.booking.bean.BookingTxnStatusRequestBean;
import com.unimoni.eod.booking.bean.SearchBookingRequestBean;
import com.unimoni.eod.booking.exception.ResourceNotFoundException;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.service.BookingService;
import com.unimoni.eod.booking.service.BookingServiceException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@PostConstruct
	public void init() {
		System.out.println("Booking Controller... Calling...");
	}
	
	//@Autowired
   // private RestTemplate restTemplate;
	
	
	@Autowired
	BookingService bookingService;
	
	
	@GetMapping(value = "/charges")
	public DeliveryCharges CalculateDeliveryCharges(@Valid @RequestParam int distance, String vehicleType) throws ResourceNotFoundException, BookingServiceException {
		
		//GprsLocation distance = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, GprsLocation.class);
		DeliveryCharges dchrgs = new DeliveryCharges();
		dchrgs.setMaxWeight(23.05);
		DeliveryCharges chrgs = bookingService.findDeliveryCharges(dchrgs);
		
		if(chrgs == null) {
			throw new BookingServiceException("Delivery Charges not found");
		}
		
		return chrgs;
	}
	
	@PostMapping(value="/confirm")
	private BookingResponseBean bookDelivery(@Valid @RequestBody BookingRequestBean request) {
		try {
			//BookingServicesImpl impl = new BookingServicesImpl();
			System.out.println("inside book delivery");
			bookingService.confirmBooking(request);
		}catch (Exception e) {
			e.getMessage();
		}
		return new BookingResponseBean();
	}
	

	@GetMapping(value="/history/{customerID}")
	private BookingHistoryResponseBean bookingHistory(@PathVariable(name="customerID", required=true) int customerID) {
			BookingHistoryResponseBean history = new BookingHistoryResponseBean();
			System.out.println("Customer id is " + customerID);
			List<BookingHistoryBean> historyList = bookingService.bookingHistory(customerID);
			history.setHistoryList(historyList);
		return history;
	}
	
	@GetMapping(value="/bookingDetails/{bookingID}")
	private BookingResponseBean bookingHistory(@PathVariable(name="bookingID", required=true) String bookingID) {
			System.out.println("inside booking details");
			BookingResponseBean responseBean = bookingService.retrieveBookingsDetails(Integer.parseInt(bookingID));
		return responseBean;
	}
	
	@PostMapping(value="/search")
	private BookingResponseListBean searchBooking(@RequestBody SearchBookingRequestBean serachBooking) {
			BookingResponseListBean finalResponse = new BookingResponseListBean();
			List<BookingResponseBean> response = new ArrayList<BookingResponseBean>();
			BookingResponseBean responseBean = new BookingResponseBean();
			for(int i=0;i<serachBooking.getBookingID().size();i++) {
				System.out.println("Booking id is " + serachBooking.getBookingID().get(i));
				responseBean = new BookingResponseBean();
				responseBean = bookingService.retrieveBookingsDetails(serachBooking.getBookingID().get(i));
				response.add(responseBean);
			}
			finalResponse.setBookingDetails(response);
		return finalResponse;
	}
	
	/*@GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }*/
	
	@GetMapping("/publish/{bookingID}")
	public String  publishBooking(@PathVariable("bookingID") final Long bookingID) {
		String str1 = bookingService.publishBookingDetail(bookingID);
		System.out.println("sfsdf" +str1 );
		return "Published booking details successfully";
	}
	
	@PostMapping(value="/txnStatus")
	public void txnStatusHistory(@RequestBody BookingTxnStatusRequestBean request) {
		
	}
	
	@RequestMapping("/home") 
	public String welcome() {
		return "Hi Restful application";
	}
	
}

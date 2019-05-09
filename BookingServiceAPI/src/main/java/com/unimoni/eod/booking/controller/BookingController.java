package com.unimoni.eod.booking.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingHistoryReponseBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.exception.ResourceNotFoundException;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.model.User;
import com.unimoni.eod.booking.service.BookingServiceException;

import com.unimoni.eod.booking.service.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	
	@PostConstruct
	public void init() {
		System.out.println("Booking Controller... Calling...");
	}
	
	//@Autowired
   // private RestTemplate restTemplate;
	
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example_json";
	
	
	@GetMapping(value = "/charges")
	public DeliveryCharges CalculateDeliveryCharges(@RequestParam int distance, String vehicleType) throws ResourceNotFoundException, BookingServiceException {
		
		//GprsLocation distance = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, GprsLocation.class);

		DeliveryCharges chrgs = bookingService.findDeliveryCharges(distance, vehicleType);
		if(chrgs == null) {
			throw new BookingServiceException("Delivery Charges not found");
		}
		
		return chrgs;
	}
	
	@PostMapping(value="/confirm")
	private BookingResponseBean bookDelivery(@Valid @RequestBody BookingRequestBean request) {
		try {
			//BookingServicesImpl impl = new BookingServicesImpl();
			bookingService.confirmBooking(request);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new BookingResponseBean();
	}
	
	@GetMapping("/history")
	private BookingHistoryReponseBean bookingHistory(@RequestParam(name="customerID",required = true) Long customerID) {
			BookingHistoryReponseBean history = new BookingHistoryReponseBean();
			
			List<BookingHistoryBean> historyList = bookingService.bookingHistory(customerID);
			history.setHistoryList(historyList);
		return history;
	}
	
	
	@GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
	
	@RequestMapping("/home") 
	public String welcome() {
		return "Hi Restful application";
	}
}

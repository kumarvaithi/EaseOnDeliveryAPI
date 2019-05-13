package com.unimoni.eod.kafka.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unimoni.eod.kafka.model.BookingNotifications;
import com.unimoni.eod.mapper.NotificationConsumer;

@Service
public class BookingNotificationsConsumer {

	@Autowired
	RestTemplate restTemplate;
	
    @KafkaListener(topics = "booking_notification", groupId = "group_id")
    public void consume(String bookingID) {
    	System.out.println("consumed message " + bookingID);
    	
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			NotificationConsumer consumer = mapper.readValue(bookingID, NotificationConsumer.class);
			restTemplate.exchange("http://localhost:8081/bookings/bookingDetails/" + consumer.getBookingID(), HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			}, bookingID).getBody();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(BookingNotifications user) {
        System.out.println("Consumed JSON Message: " + user);
    }

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json1",
        containerFactory = "userKafkaListenerFactory")
    public void consumeJson2(BookingNotifications user) {
        System.out.println("Consumed JSON Message: " + user);
    }
    
    @Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

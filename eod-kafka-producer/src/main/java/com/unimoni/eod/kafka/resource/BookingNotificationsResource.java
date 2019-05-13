package com.unimoni.eod.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.eod.kafka.model.BookingNotifications;

@RestController
@RequestMapping("kafka")
public class BookingNotificationsResource {

    @Autowired
    private KafkaTemplate<String, BookingNotifications> kafkaTemplate;

    private static final String TOPIC = "booking_notification";

    @GetMapping("/publish/{bookingID}")
    public String post(@PathVariable("bookingID") final String bookingID) {

        kafkaTemplate.send(TOPIC, new BookingNotifications(bookingID));

        return "Published successfully";
    }
}

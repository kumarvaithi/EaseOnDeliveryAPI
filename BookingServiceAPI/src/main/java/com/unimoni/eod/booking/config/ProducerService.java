package com.unimoni.eod.booking.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.unimoni.eod.booking.bean.BookingResponseBean;


@Configuration
public class ProducerService {
	

	 	@Bean
	    public ProducerFactory<String, BookingResponseBean> producerFactory() {
	        Map<String, Object> config = new HashMap<>();

	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	        // producer wait for acknowledge
	        //  config.put(ProducerConfig.ACKS_CONFIG, "all");

	        return new DefaultKafkaProducerFactory<>(config);
	    }
	 	

	    @Bean
	    public KafkaTemplate<String, BookingResponseBean> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }


	
}

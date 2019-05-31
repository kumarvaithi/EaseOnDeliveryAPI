package com.unimoni.eod.booking.apps;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.unimoni.eod.booking.controller.BookingController;
import com.unimoni.eod.booking.service.BookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingService bookingService;
	
}

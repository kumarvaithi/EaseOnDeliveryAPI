package com.unimoni.eod.booking.apps;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnitTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Test
	public void testMyCode(TestInfo testInfo) {
		int businessResult = 1;
		//assertEquals(expected: 1 , businessResult, message: "Expecting a value 1 ");
	}
 
	
	
	@Test
	@EnabledIf("systemProperty.get('test2' == true")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testMethod2(int rate) {
		logger.info("Test method2");
		//calculateExchange(rate);
	}
	
	
}

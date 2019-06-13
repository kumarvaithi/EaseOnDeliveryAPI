package com.unimoni.eod.booking.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unimoni.eod.booking.model.OTPDetails;
import com.unimoni.eod.booking.repo.OTPDetailsRepositary;  

@Component
public class CommonMethodUtils {

		@Autowired
		OTPDetailsRepositary oTPDetailsRepositary;
	
	public static Timestamp convertStringtoDate(String inDate) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		    Date parsedDate = dateFormat.parse(inDate);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return timestamp;
	}
	
	@SuppressWarnings("unused")
	public int generateOTP(int length,int bookingID,String userType) {
      String numbers = "1234567890";
      Random random = new Random();
      char[] otp = new char[length];

      for(int i = 0; i< length ; i++) {
         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
      }
      
      int finalOTP = Integer.parseInt(String.valueOf(otp));
//      Optional<OTPDetails> otpDetails = oTPDetailsRepositary.findByOtpAndStatus(finalOTP,"I");
      
//      if(otpDetails.isPresent()){
//    	  generateOTP(4,bookingID,userType);
//      }
      
      return finalOTP;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(CommonMethodUtils.convertStringtoDate("2019-05-12 21:20"));
	}
}

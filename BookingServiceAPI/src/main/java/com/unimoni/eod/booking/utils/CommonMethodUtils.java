package com.unimoni.eod.booking.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.unimoni.eod.booking.model.OTPDetails;
import com.unimoni.eod.booking.repo.OTPDetailsRepositary;  

public class CommonMethodUtils {

	@Autowired
	OTPDetailsRepositary otpRepo;
	
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
	private int generateOTP(int length,int bookingID,String userType) {
      String numbers = "1234567890";
      Random random = new Random();
      char[] otp = new char[length];

      for(int i = 0; i< length ; i++) {
         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
      }
      
      int finalOTP = Integer.parseInt(String.valueOf(otp));
      List<OTPDetails> otpDetails = otpRepo.findByOTPAndStatus(finalOTP,"I");
      
      if(otpDetails.size() > 0){
    	  generateOTP(4,bookingID,userType);
      }
      
      otpRepo.save(new OTPDetails()
    		  .setBookingID(bookingID)
    		  .setGeneratedOn(LocalDate.now())
    		  .setOTP(finalOTP)
    		  .setStatus("I")
    		  .setUserType(userType));
      
      return finalOTP;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(CommonMethodUtils.convertStringtoDate("2019-05-12 21:20"));
	}
}

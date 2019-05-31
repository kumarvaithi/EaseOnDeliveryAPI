package com.unimoni.eod.booking.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class CommonMethodUtils {

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
	
	public static void main(String[] args) {
		
		System.out.println(CommonMethodUtils.convertStringtoDate("2019-05-12 21:20"));
	}
}

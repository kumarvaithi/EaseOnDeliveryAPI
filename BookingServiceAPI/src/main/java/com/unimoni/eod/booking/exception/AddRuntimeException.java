package com.unimoni.eod.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AddRuntimeException extends RuntimeException {
	
	public AddRuntimeException(String message) {
		super(message);
	}

	public AddRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
	
}

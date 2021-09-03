package com.example.springboot.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timeStamp;
	
	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}
	
	
	
}

package com.example.springboot.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		ApiException apiException=new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> customValidationErrorHandling(MethodArgumentNotValidException ex){
		ApiException apiException=new ApiException(ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<Object>(apiException,HttpStatus.BAD_REQUEST);
	}

}

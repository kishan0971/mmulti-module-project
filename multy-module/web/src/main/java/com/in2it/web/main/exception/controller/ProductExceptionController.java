package com.in2it.web.main.exception.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.in2it.exception.ResourceNotFoundException;
import com.in2it.exception.response.ExceptionResponse;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> customerNotFound(ResourceNotFoundException exception, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(),request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}


}

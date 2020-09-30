package com.cts.gateway.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.gateway.model.ResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GenericNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleNotFoundException(GenericNotFoundException ex){
		return new ResponseEntity<ResponseMessage>(
					new ResponseMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage()),
					HttpStatus.NOT_FOUND
				);
				
	}
	
	@ExceptionHandler(GenericAlreadyExistException.class)
	public ResponseEntity<ResponseMessage> handleAlreadyExistException(GenericAlreadyExistException ex){
		return new ResponseEntity<ResponseMessage>(
					new ResponseMessage(LocalDateTime.now(), HttpStatus.CONFLICT, ex.getMessage()),
					HttpStatus.CONFLICT
				);
				
	}
}

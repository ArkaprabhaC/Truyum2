package com.cts.project101.userdbservice.globalexceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.project101.userdbservice.exception.EmailIDExistException;
import com.cts.project101.userdbservice.exception.EmailIDNotFoundException;
import com.cts.project101.userdbservice.exception.UsernameExistException;
import com.cts.project101.userdbservice.exception.UsernameNotFoundException;
import com.cts.project101.userdbservice.model.ResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailIDNotFoundException.class)
	ResponseEntity<?> emailIDNotFoundExceptionHandler(EmailIDNotFoundException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, e.getMessage()));
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	ResponseEntity<?> usernameNotFoundExceptionHandler(UsernameNotFoundException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND, e.getMessage()));
	}
	
	@ExceptionHandler(EmailIDExistException.class)
	ResponseEntity<?> emailIDExistExceptionHandler(EmailIDExistException e) {

		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ResponseMessage(LocalDateTime.now(), HttpStatus.CONFLICT, e.getMessage()));
	}
	
	@ExceptionHandler(UsernameExistException.class)
	ResponseEntity<?> usernameExistExceptionHandler(UsernameExistException e) {

		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ResponseMessage(LocalDateTime.now(), HttpStatus.CONFLICT, e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		
		
		BindingResult bindingResult = e.getBindingResult();
		
		String errorstr=""; 
		
		for(FieldError fieldErrors : bindingResult.getFieldErrors())
		{
			errorstr+=fieldErrors.getDefaultMessage()+" ";
		}
		
		errorstr=errorstr.trim();
		
		

		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ResponseMessage(LocalDateTime.now(), HttpStatus.CONFLICT, errorstr));
	}
	

}

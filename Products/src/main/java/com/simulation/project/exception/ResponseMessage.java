package com.simulation.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
	
	private HttpStatus status;
	private String message;
	private LocalDateTime timestamp;
	
	public ResponseMessage() {
		super();
	}

	public ResponseMessage(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

	

}
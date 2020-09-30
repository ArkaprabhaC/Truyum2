package com.cts.project101.userdbservice.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
	
	private LocalDateTime timestamp;
	
	private HttpStatus status;
	
	private String message;

}

package com.cts.gateway.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.gateway.model.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
	
	/**
	 * default Decoder
	 */
	private final transient ErrorDecoder defaultDecoder = new Default();
	
	/**
	 * Responseformat object
	 */
	private transient ResponseMessage error;
	
	/**
	 * Slf4j Logger
	 */
	private static final transient Logger LOGGER = LoggerFactory.getLogger(CustomErrorDecoder.class);
	
	@Override
	public Exception decode(String methodKey, Response response) {
		
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			error = mapper.readValue(response.body().asInputStream(), ResponseMessage.class);
			
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
		
		
		Exception exception;
		switch (response.status()) {
			case 404:
				exception =  new GenericNotFoundException(error.getMessage());
				break;
				
			case 409:
				exception = new GenericAlreadyExistException(error.getMessage()); 
				break;
				
			default:
				exception = defaultDecoder.decode(methodKey, response);
				break;
		}
		
		return exception;
		
	}

	

}

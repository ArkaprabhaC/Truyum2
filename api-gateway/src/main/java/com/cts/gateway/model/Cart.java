package com.cts.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	private int serialNo;
	
	private String productName;
	
	private float price;
	
	private String description;
	
	private int pid;
	
	private int userId;
		
}

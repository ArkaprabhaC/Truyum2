package com.simulation.project.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.simulation.project.DAO.CartDAO;
import com.simulation.project.clients.ProductClient;
import com.simulation.project.exception.CartEmptyException;
import com.simulation.project.exception.ResponseMessage;
import com.simulation.project.model.Cart;

@Service
public class CartService {
	
	@Autowired
	CartDAO dao;
	
	@Autowired
	private ProductClient client;

	public List<Cart> getItems(int userId) 
	{
		return (List<Cart>) dao.findByUserId(userId).orElseThrow(()-> new CartEmptyException("Cart is empty"));	
	}

	public ResponseMessage removeItem(int userId,int pid) 
	{
		if(!dao.findByUserId(userId).isPresent())
		{
			throw new NullPointerException("Product not found!");
		}
		dao.deleteCartItemByUserIdAndPid(userId, pid);
		return new ResponseMessage(HttpStatus.OK, "Deleted Item from Cart Successfully");
	}


	public ResponseMessage addItem(int userId,int pid)
	{
		 Cart product = client.getProductByID(pid);
		 product.setPid(pid);
		 product.setUserId(userId);
		 
		 dao.save(product);
		 return new ResponseMessage(HttpStatus.OK, "Product added successfully");
	}
	

	

}

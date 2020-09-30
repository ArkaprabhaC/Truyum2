package com.simulation.project.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.simulation.project.DAO.ProductDAO;
import com.simulation.project.exception.AlreadyExistException;
import com.simulation.project.exception.ResponseMessage;
import com.simulation.project.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDAO dao;


	
	public ResponseMessage addProduct(Product product)
	{
		if(dao.findById(product.getId()).isPresent())
		{
			throw new AlreadyExistException("Product already exist!");
		}
		 dao.save(product);
		 return new ResponseMessage(HttpStatus.OK, "Product added successfully");
	}
	
	
	public List<Product> getProducts()
	{
		return (List<Product>) dao.findAll();
	}
	
	
	public ResponseMessage removeProduct(int id)
	{
		if(!dao.findById(id).isPresent())
		{
			throw new NullPointerException("Product not found!");
		}
		dao.deleteById(id);
		return new ResponseMessage(HttpStatus.OK, "Deleted Successfully");
	}


	public Product getProduct(int id) {
		return dao.findById(id).orElseThrow(() -> new NullPointerException("No products found!"));
	}
	
	
}

package com.cts.gateway.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.gateway.model.Product;
import com.cts.gateway.model.ResponseMessage;



@FeignClient(name="PRODUCTSERVICE", url="${PRODUCTSERVICE:http://localhost:8081}")
@RequestMapping("/products")
public interface ProductProxy {
	
	@PostMapping(value="/add" )
	public ResponseEntity<ResponseMessage> createProduct(@RequestBody Product product);
	
	@GetMapping("/{id}")
	public Product getProductByID(@PathVariable("id") int id);
	
	@GetMapping(value="/all" )
	public List<Product> getAllProducts();
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteProduct(  @PathVariable("id") int id);

}

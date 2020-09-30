package com.simulation.project.DAO;

import org.springframework.data.repository.CrudRepository;

import com.simulation.project.model.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {

}

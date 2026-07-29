package com.demo.dao;

import java.util.List;

public interface Product {

	boolean saveProduct(Product p);

	List<Product> findAll();

	boolean saveProduct(com.demo.model.Product p);

	boolean saveProduct(double pr);

}
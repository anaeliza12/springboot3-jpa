package com.devesuperior.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devesuperior.course.entities.Product;
import com.devesuperior.course.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> category = productRepository.findById(id);
		return category.get();
	}

}

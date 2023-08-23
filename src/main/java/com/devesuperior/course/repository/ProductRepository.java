package com.devesuperior.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

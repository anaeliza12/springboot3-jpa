package com.devesuperior.course.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}

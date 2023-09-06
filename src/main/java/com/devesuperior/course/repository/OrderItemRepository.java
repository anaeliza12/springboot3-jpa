package com.devesuperior.course.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.course.entities.Category;
import com.devesuperior.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	

}

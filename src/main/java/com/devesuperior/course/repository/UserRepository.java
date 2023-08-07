package com.devesuperior.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

	

}

package com.devesuperior.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesuperior.course.entities.Payment;
import com.devesuperior.course.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	public List<Payment> findAll() {

		return paymentRepository.findAll();

	}

	public Payment findById(Long id) {
		return paymentRepository.findById(id).get();
	}

}

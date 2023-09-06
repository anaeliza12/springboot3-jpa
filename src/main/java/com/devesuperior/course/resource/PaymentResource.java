package com.devesuperior.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesuperior.course.entities.Payment;
import com.devesuperior.course.service.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	PaymentService paymentService;

	@GetMapping
	public ResponseEntity<List<Payment>> findAll() {
		return ResponseEntity.ok().body(paymentService.findAll());
	}

	@GetMapping(value = { "/id" })
	public ResponseEntity<Payment> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(paymentService.findById(id));
	}
}

package com.devesuperior.course.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devesuperior.course.service.exceptions.ResourceNotFoundException;
import com.devesuperior.course.service.exceptions.DataBaseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExcepetionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError standart = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standart);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandartError> dataBase(DataBaseException e, HttpServletRequest request) {
		String error = "Data base error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError standart = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(standart);
	}

	
}

package com.devesuperior.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devesuperior.course.entities.User;
import com.devesuperior.course.repository.UserRepository;
import com.devesuperior.course.service.exceptions.DataBaseException;
import com.devesuperior.course.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long user) {
		try {
			repository.deleteById(user);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(user);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		try {

			updateData(user, entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		return repository.save(entity);
	}

	private void updateData(User user, User entity) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}

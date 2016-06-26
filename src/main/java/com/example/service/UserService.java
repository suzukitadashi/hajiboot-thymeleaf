package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User findOne(String id) {
		return userRepository.findOne(id);
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	
}

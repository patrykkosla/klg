package com.pat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pat.model.User;
import com.pat.repository.UserRepository;
import com.pat.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User getUserById(Long id) {
		 return userRepository.getById(id);
	}

}

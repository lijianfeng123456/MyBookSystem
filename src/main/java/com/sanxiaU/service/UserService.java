package com.sanxiaU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanxiaU.dao.UserDao;
import com.sanxiaU.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public User userLogin(User user) {
		return dao.userLogin(user);
	}

}

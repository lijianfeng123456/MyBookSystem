package com.sanxiaU.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanxiaU.dao.ManageDao;
import com.sanxiaU.entity.Manage;

@Service
public class ManageService {
	@Autowired
	private ManageDao manageDao;
	
	public Manage manageLogin(Manage manage){
		return manageDao.manageLogin(manage);
		
	}
	
	public void manageLoginIpAndTime(Manage manage){
		manageDao.manageLoginIpAndTime(manage);
	}
}

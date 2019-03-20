package com.sanxiaU.dao;

import com.sanxiaU.entity.Manage;

public interface ManageDao {
	Manage manageLogin(Manage manage);
	void manageLoginIpAndTime(Manage manage);
}

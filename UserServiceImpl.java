package com.cts.fsd.pms.services.userlogin.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fsd.pms.services.userlogin.UserService;
import com.cts.fsd.pms.services.userlogin.domain.model.UserInfo;
import com.cts.fsd.pms.services.userlogin.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired	
	private UserRepository userRepository;
	
	@Override
	public List<UserInfo> getUserInfoList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserInfo getUserInfoByKey(long userKey) {
		// TODO Auto-generated method stub
		return userRepository.findOne(userKey);
	}

	@Override
	public UserInfo getUserInfoByName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}

package com.cts.fsd.pms.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fsd.pms.services.userlogin.UserService;
import com.cts.fsd.pms.services.userlogin.domain.model.UserInfo;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('Admin')")
	public List<UserInfo> getAllUserInfo() {
		logger.info("Fetch all UserInfo");
		
		return userService.getUserInfoList();
	}

}

package com.cts.fsd.pms.services.userlogin.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.fsd.pms.services.userlogin.UserService;
import com.cts.fsd.pms.services.userlogin.domain.model.UserGroup;
import com.cts.fsd.pms.services.userlogin.domain.model.UserInfo;

@Service
public class UserLoginDetailsServiceImpl implements UserDetailsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = null;
		UserInfo userInfo = userService.getUserInfoByName(userName);
		
		if(userInfo == null) {
			throw new UsernameNotFoundException("User name: " + userName + " not found.");
		}
		else {
			
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			
			for(UserGroup userGroup : userInfo.getUserGroups()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + userGroup.getGroupName()));
			}
			
			user = new User(userInfo.getUserName(), userInfo.getPassword(), authorities);
			 
		}
		return user;
	}

}

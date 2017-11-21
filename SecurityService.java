package com.cts.fsd.pms.services.authentication;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
	
}

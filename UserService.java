package com.cts.fsd.pms.services.userlogin;

import java.util.List;

import com.cts.fsd.pms.services.userlogin.domain.model.UserInfo;

public interface UserService {

	public List<UserInfo> getUserInfoList();
	
	public UserInfo getUserInfoByKey(long userKey);
	
	public UserInfo getUserInfoByName(String userName);
	
}

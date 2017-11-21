package com.cts.fsd.pms.services.userlogin.domain.repository;

import org.springframework.data.jpa.repository.*;

import com.cts.fsd.pms.services.userlogin.domain.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

	UserInfo findByUserName(String userName);
	
}

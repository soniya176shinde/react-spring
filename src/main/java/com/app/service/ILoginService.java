package com.app.service;

import com.app.dto.LoginDto;
import com.app.pojos.Login;

public interface ILoginService {

	 
	Login addUserDetails(LoginDto user);
	Login authenticateUser(String email, String password);

}

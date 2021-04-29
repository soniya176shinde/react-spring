package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.user_excs.UserHandlingException;
import com.app.dao.AuthRepository;
import com.app.dao.LoginRepository;
import com.app.dto.LoginDto;
import com.app.pojos.Login;
@Service
@Transactional 
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	private LoginRepository userRepo;

	@Autowired
	private AuthRepository authRepo;

	@Override
	public Login addUserDetails(LoginDto userDto) {
		Login user = new Login();
		BeanUtils.copyProperties(userDto, user);
		System.out.println("add user src : " +userDto);
		System.out.println(user);
		// invoke dao's method for persistence
		return userRepo.save(user);
	}

	@Override
	public Login authenticateUser(String email, String password) {
		return authRepo.validateUser(email, password)
				.orElseThrow(() -> new UserHandlingException("Invalid Credentials!!!!"));

	}

}

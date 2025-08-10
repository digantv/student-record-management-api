package com.redpluto.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redpluto.common.ResponseCodes;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepo;

    public LoginResponse validateUser(LoginRequest loginRequest) {

	LoginResponse response = new LoginResponse();

	List<User> liuser = userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

	if (liuser.size() == 1) {
	    response.setStatus(ResponseCodes.LOGIN_SUCCESS.getStatus());
	    response.setMessage(ResponseCodes.LOGIN_SUCCESS.getMessage());
	} else {
	    response.setStatus(ResponseCodes.LOGIN_FAIL.getStatus());
	    response.setMessage(ResponseCodes.LOGIN_FAIL.getMessage());
	}
	return response;
    }
}

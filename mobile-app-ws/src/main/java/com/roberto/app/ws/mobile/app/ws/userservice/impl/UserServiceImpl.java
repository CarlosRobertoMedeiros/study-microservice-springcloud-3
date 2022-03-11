package com.roberto.app.ws.mobile.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.app.ws.mobile.app.ws.shared.Utils;
import com.roberto.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.roberto.app.ws.mobile.app.ws.ui.model.response.UserRest;
import com.roberto.app.ws.mobile.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private Map<String, UserRest> users;
	private Utils utils;
	
	@Autowired
	public UserServiceImpl(Utils utils){
		this.utils = utils;
	}
	
	 
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = utils.generateUserId();
		returnValue.setUserId(userId);
		if (users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

}

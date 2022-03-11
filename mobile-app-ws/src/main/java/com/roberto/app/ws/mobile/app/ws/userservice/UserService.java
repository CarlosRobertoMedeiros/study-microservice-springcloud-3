package com.roberto.app.ws.mobile.app.ws.userservice;

import com.roberto.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.roberto.app.ws.mobile.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);

}

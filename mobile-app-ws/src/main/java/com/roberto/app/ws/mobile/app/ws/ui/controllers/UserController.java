package com.roberto.app.ws.mobile.app.ws.ui.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.app.ws.mobile.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.roberto.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequestModel;
import com.roberto.app.ws.mobile.app.ws.ui.model.response.UserRest;
import com.roberto.app.ws.mobile.app.ws.userservice.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	private Map<String, UserRest> users;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page, 
						   @RequestParam(value = "limit", defaultValue = "50") int limit,
						   @RequestParam(value = "sort", defaultValue = "desc",  required = false) String sort) {
		return "get users was called with page = "+page + " and limit = "+limit+ " and sort =" + sort;
	}
	
	@GetMapping(path = "/{userId}", 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		//Testa erro primeiro depois  Null Pointer
		//String firstName = null;
		//int firstNameLength = firstName.length();
		//Fim do Teste para Validar as Exceptions
		
		//Testa erros e trabalha os mesmos por regra de neg??cio
		//if (true) throw new UserServiceException("A user service Exception is thrown");
		
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
			     produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }
				)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);	
	}
	
	@PutMapping(path = "/{userId}",
				consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
		        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails =  users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		users.put(userId, storedUserDetails);
		return storedUserDetails;
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();	
	}
	
	

}

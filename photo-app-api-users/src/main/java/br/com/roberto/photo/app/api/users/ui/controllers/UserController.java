package br.com.roberto.photo.app.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.photo.app.api.users.service.UsersService;
import br.com.roberto.photo.app.api.users.shared.UserDto;
import br.com.roberto.photo.app.api.users.ui.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsersService usersService;
		
	@GetMapping("/status/check")
	public String status() {
		return "Working on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MathingStrategies.STRICT);
		
		return "Created user method is called";
	}
	
	

}

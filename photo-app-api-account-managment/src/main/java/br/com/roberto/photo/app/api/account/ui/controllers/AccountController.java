package br.com.roberto.photo.app.api.account.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@GetMapping(value = "/status/check")
	public String status() {
		return "Working Account";
	} 

}

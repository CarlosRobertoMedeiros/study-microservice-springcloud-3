package com.roberto.app.ws.mobile.app.ws.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.roberto.app.ws.mobile.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage erroMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);

		return new ResponseEntity<>(erroMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage erroMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);

		return new ResponseEntity<>(erroMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = ex.toString();

		ErrorMessage erroMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);

		return new ResponseEntity<>(erroMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Para combinar 2 métodos de exceção, basta utilizá-los no array
	//Ex.
	//@ExceptionHandler(value = { NullPointerException, UserServiceException.class })
	//public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
	
}

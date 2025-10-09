package com.ggocodelab.dscommercev2.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ggocodelab.dscommercev2.dto.CustomError;
import com.ggocodelab.dscommercev2.dto.ValidationError;
import com.ggocodelab.dscommercev2.services.exceptions.DatabaseException;
import com.ggocodelab.dscommercev2.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(
				Instant.now(), 
				status.value(), 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(
				Instant.now(), 
				status.value(), 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(
				Instant.now(), 
				status.value(), 
				e.getMessage(), 
				request.getRequestURI());
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}		
		return ResponseEntity.status(status).body(err);		
	}
}

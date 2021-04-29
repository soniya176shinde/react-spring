package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;
import com.app.user_excs.UserHandlingException;

@ControllerAdvice // Mandatory class level annotation to tell SC whatever follows is centralized
					// exc handler class
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//exc handling method/s :
	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<ErrorResponse> handleUserHandlingException(UserHandlingException e) {
		System.out.println("in handle customer exc");
		return new ResponseEntity<>(new ErrorResponse("Invalid Login", e.getMessage()),
				 HttpStatus.UNAUTHORIZED);
	}
	//	catch all -- equivalent
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		System.out.println("in handle any exc");
		return new ResponseEntity<>(new ErrorResponse("Servr side error !!!!",e.getMessage()),
				 HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}


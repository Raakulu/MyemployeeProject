package org.rakesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Object> exception(IdNotFoundException exception){
		return new ResponseEntity<Object>(exception.getId() + " :Id doesn't exists in the table", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = IdAlreadyExistsException.class)
	public ResponseEntity<Object> exception(IdAlreadyExistsException exception){
		return new ResponseEntity<Object>(exception.getId() + " :Id already exists in the table", HttpStatus.NOT_ACCEPTABLE);
	}

}

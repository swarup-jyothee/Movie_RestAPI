package org.restapi.movie.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlingException {
	@ExceptionHandler(DataisPresentException.class)
	public ResponseEntity<HashMap<String,String>> handle(DataisPresentException exception){
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<HashMap<String,String>>handle(NoDataFoundException exception){
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("message", exception.getNote());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}

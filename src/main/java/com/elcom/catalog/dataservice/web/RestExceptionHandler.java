package com.elcom.catalog.dataservice.web;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elcom.catalog.dataservice.root.DataServiceResponse;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<DataServiceResponse> handleMissingRequestBody(Exception ex) {
	  
		DataServiceResponse ur = DataServiceResponse.builder()
									  .isSuccess(false)
									  .responseMessage("Bad request - problem with request json: "+ ex.getCause().getLocalizedMessage())
									  .build();
		
		return ResponseEntity.badRequest()
							 .body(ur);
	}
  
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<DataServiceResponse> handleResourceNotFound(Exception ex) {
	  
		return badResponse("Requested resource not found - please check your realm");
		
	}
	
	@ExceptionHandler(InvalidDefinitionException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<DataServiceResponse> handleInvalidDefinitionException(Exception ex) {
	
		return badResponse("Problem with request JSON: "+ex.getCause().getLocalizedMessage());
		
	}
	
	private ResponseEntity<DataServiceResponse> badResponse(String message) {
		
		DataServiceResponse ur = DataServiceResponse.builder()
				  .isSuccess(false)
				  .responseMessage(message)
				  .build();
		
		return ResponseEntity.badRequest()
				 .body(ur);
		
	}
}
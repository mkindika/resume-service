package com.codeworxs.resume.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeworxs.resume.payload.ErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ServiceException handleServiceException(ServiceException ex) {
        return ex;
    }
	
}

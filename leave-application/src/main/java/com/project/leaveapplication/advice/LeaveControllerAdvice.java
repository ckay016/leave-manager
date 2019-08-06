package com.project.leaveapplication.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.leaveapplication.exceptions.ResourceNotFoundException;
@RestControllerAdvice
public class LeaveControllerAdvice 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleException(ResourceNotFoundException  e) 
	{
    	return e.getMessage();
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public String handleBadRequestException(MethodArgumentNotValidException ex) {
        return "Input not valid." + ex.getParameter();
    }
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return "Input not valid. " + ex.getMessage();
    }
}

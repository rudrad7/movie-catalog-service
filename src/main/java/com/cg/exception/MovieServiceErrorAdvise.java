package com.cg.exception;
import java.sql.SQLException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;
@ControllerAdvice
public class MovieServiceErrorAdvise 
{
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {Exception.class})
	protected ErrorInfo handleConflict(Exception ex, HttpServletRequest req)
	{		
		String bodyOfResponse = ex.getMessage();// "movie with this id not present";
		String uri = req.getRequestURL().toString();
		ErrorInfo ei=new ErrorInfo(uri,bodyOfResponse);
		System.out.println("--handleConflict executed-:"+ei);
		return   ei;
	}
	
	//--------------------------------------
	@ExceptionHandler({MovieNotFoundException.class, 
		SQLException.class, NullPointerException.class})
	public ResponseEntity<String> handle1(MovieNotFoundException ue) 
	{
		 System.out.println("--------handle1 executed------------");
		return error(HttpStatus.INTERNAL_SERVER_ERROR, ue);
	}		
	private ResponseEntity<String> error(HttpStatus status, Exception e)
	{
		System.out.println("--------error executed------------");
		return ResponseEntity.status(status).body(e.getMessage());
	}

}

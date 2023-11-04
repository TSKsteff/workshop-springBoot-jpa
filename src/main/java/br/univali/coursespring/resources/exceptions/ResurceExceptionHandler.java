package br.univali.coursespring.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.univali.coursespring.services.exceptions.ResourceNotFoundExceptoin;

@ControllerAdvice
public class ResurceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExceptoin.class)
	public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundExceptoin e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}

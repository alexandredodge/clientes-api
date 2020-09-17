package io.github.alexandredodge.clientes.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.alexandredodge.clientes.rest.exception.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiErrors handleValidationErrors( MethodArgumentNotValidException exception ) {
		BindingResult bindingResult =  exception.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
			.stream()
			.map( ObjectError -> ObjectError.getDefaultMessage())
			.collect(Collectors.toList());
		return new ApiErrors(messages);
	}
}

package com.souzavaltenis.originaldesafio.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.souzavaltenis.originaldesafio.service.exception.GrafoNaoEncontradoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(GrafoNaoEncontradoException.class)
	public ResponseEntity<ErrorMessage> grafoNaoEncontrado(GrafoNaoEncontradoException e, HttpServletRequest request) {

		String error = "Grafo não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorMessage errorMessage = new ErrorMessage(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(errorMessage);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> erroGlobal(Exception e, HttpServletRequest request) {

		String error = e.getClass().getName();
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorMessage errorMessage = new ErrorMessage(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(errorMessage);
	}

}
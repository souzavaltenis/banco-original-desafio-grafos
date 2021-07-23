package com.souzavaltenis.originaldesafio.service.exception;

public class GrafoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public GrafoNaoEncontradoException(Object id) {
		super("Nenhum grafo foi encontrado com Id: " + id);
	}
}

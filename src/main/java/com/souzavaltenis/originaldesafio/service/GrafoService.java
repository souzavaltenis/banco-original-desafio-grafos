package com.souzavaltenis.originaldesafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.repository.GrafoRepository;
import com.souzavaltenis.originaldesafio.service.exception.GrafoNaoEncontradoException;

@Service
public class GrafoService {

    @Autowired
    private GrafoRepository repository;
    
    public Grafo buscarPorId(Integer id) {
    	Optional<Grafo> grafo = repository.findById(id);
    	return grafo.orElseThrow(() -> new GrafoNaoEncontradoException(id));
    }
    
    public Grafo inserir(Grafo grafo) {
    	return repository.save(grafo);
    }
 
}

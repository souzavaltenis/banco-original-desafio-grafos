package com.souzavaltenis.originaldesafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.repository.GrafoRepository;
import com.souzavaltenis.originaldesafio.service.exception.ResourceNotFoundException;

@Service
public class GrafoService {

    @Autowired
    private GrafoRepository repository;
    
    public Grafo findById(Integer id) {
    	Optional<Grafo> grafo = repository.findById(id);
    	return grafo.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public Grafo insert(Grafo grafo) {
    	return repository.save(grafo);
    }
 
}

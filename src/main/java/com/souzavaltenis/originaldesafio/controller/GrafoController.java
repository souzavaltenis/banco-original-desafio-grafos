package com.souzavaltenis.originaldesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzavaltenis.originaldesafio.service.ArestaService;
import com.souzavaltenis.originaldesafio.service.GrafoService;
import com.souzavaltenis.originaldesafio.service.VerticeService;
import com.souzavaltenis.originaldesafio.service.exception.ResourceNotFoundException;
import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.dto.DataDTO;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;

@RestController
@RequestMapping("/graph")
public class GrafoController {
	
    @Autowired
    private GrafoService grafoService;
    
    @Autowired
    private VerticeService verticeService;
    
    @Autowired
    private ArestaService arestaService;
    
    @PostMapping
    public ResponseEntity<GrafoDTO> inserir(@RequestBody DataDTO data) {
    	
    	List<ArestaDTO> arestas = data.getData();
    	Grafo grafo = new Grafo();
    	
    	verticeService.adicionarVertices(grafo.getVertices(), arestas);
    	arestaService.adicionarArestas(grafo, arestas);
    	grafoService.insert(grafo);
    	
    	List<ArestaDTO> arestasDTO = arestaService.criarArestasDTO(grafo);
    	GrafoDTO grafoDTO = new GrafoDTO(grafo.getId(), arestasDTO);

    	return ResponseEntity.status(HttpStatus.CREATED).body(grafoDTO);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<GrafoDTO> buscar(@PathVariable Integer id){
    	
    	Grafo grafo = null;
    	
    	try {
    		grafo = grafoService.findById(id);
    	}catch(ResourceNotFoundException e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
    	List<ArestaDTO> arestasDTO = arestaService.criarArestasDTO(grafo);
    	
    	GrafoDTO grafoDTO = new GrafoDTO(grafo.getId(), arestasDTO);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(grafoDTO);
	}
    
}

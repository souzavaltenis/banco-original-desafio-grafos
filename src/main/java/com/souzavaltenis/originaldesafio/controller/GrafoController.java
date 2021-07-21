package com.souzavaltenis.originaldesafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzavaltenis.originaldesafio.service.GrafoService;
import com.souzavaltenis.originaldesafio.service.exception.ResourceNotFoundException;
import com.souzavaltenis.originaldesafio.util.GrafoUtil;
import com.souzavaltenis.originaldesafio.dto.DataDTO;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;

@RestController
@RequestMapping("/graph")
public class GrafoController {
	
    @Autowired
    private GrafoService grafoService;

    @PostMapping
    public ResponseEntity<GrafoDTO> inserir(@RequestBody DataDTO data) {
    	
    	Grafo grafo = GrafoUtil.dataDTOParaGrafo(data);
    	grafoService.insert(grafo);
    	
    	GrafoDTO grafoDTO = GrafoUtil.grafoParaDTO(grafo);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(grafoDTO);
    }
    
    @GetMapping(value = "/{graphId}")
    public ResponseEntity<GrafoDTO> buscar(@PathVariable Integer graphId){
    	
    	Grafo grafo = null;
    	
    	try {
    		grafo = grafoService.findById(graphId);
    	}catch(ResourceNotFoundException e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
    	GrafoDTO grafoDTO = GrafoUtil.grafoParaDTO(grafo);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(grafoDTO);
	}
    
}

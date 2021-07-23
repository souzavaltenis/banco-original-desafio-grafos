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
import com.souzavaltenis.originaldesafio.util.GrafoUtil;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;

@RestController
@RequestMapping("/graph")
public class GrafoController {
	
    @Autowired
    private GrafoService grafoService;

    @PostMapping
    public ResponseEntity<GrafoDTO> inserir(@RequestBody GrafoDTO data) {
    	
    	Grafo grafo = GrafoUtil.grafoDTOParaGrafo(data);
    	grafoService.inserir(grafo);
    	
    	GrafoDTO grafoCriado = GrafoUtil.grafoParaGrafoDTO(grafo);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(grafoCriado);
    }
    
    @GetMapping(value = "/{graphId}")
    public ResponseEntity<GrafoDTO> buscar(@PathVariable Integer graphId){
    	
    	Grafo grafo = grafoService.buscarPorId(graphId);

    	GrafoDTO grafoEncontrado = GrafoUtil.grafoParaGrafoDTO(grafo);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(grafoEncontrado);
	}
    
}

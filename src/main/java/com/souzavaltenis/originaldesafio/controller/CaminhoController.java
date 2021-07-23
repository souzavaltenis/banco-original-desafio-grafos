package com.souzavaltenis.originaldesafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.souzavaltenis.originaldesafio.service.GrafoService;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.dto.RoutesDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.util.CaminhoUtil;
import com.souzavaltenis.originaldesafio.util.GrafoUtil;

@RestController
@RequestMapping("/routes")
public class CaminhoController {
	
    @Autowired
    private GrafoService grafoService;
    
    @PostMapping(value = "/from/{town1}/to/{town2}")
    public ResponseEntity<RoutesDTO> encontrarCaminhos(@RequestBody GrafoDTO grafoDTO, @PathVariable String town1, @PathVariable String town2, 
    		@RequestParam(value = "maxStops", required = false) Integer maxStops){

    	Grafo grafo = GrafoUtil.grafoDTOParaGrafo(grafoDTO);
    	
    	RoutesDTO caminhosEncontrados = CaminhoUtil.criarRoutesDTO(grafo, town1, town2, maxStops);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(caminhosEncontrados);
	}
    
    @PostMapping(value = "/{graphId}/from/{town1}/to/{town2}")
    public ResponseEntity<RoutesDTO> encontrarCaminhos(@PathVariable Integer graphId, @PathVariable String town1, @PathVariable String town2, 
    		@RequestParam(value = "maxStops", required = false) Integer maxStops){

    	Grafo grafo = grafoService.buscarPorId(graphId);

    	RoutesDTO caminhosEncontrados = CaminhoUtil.criarRoutesDTO(grafo, town1, town2, maxStops);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(caminhosEncontrados);
	}
}


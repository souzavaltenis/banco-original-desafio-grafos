package com.souzavaltenis.originaldesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzavaltenis.originaldesafio.dto.DistanciaDTO;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.service.GrafoService;
import com.souzavaltenis.originaldesafio.util.DistanciaUtil;
import com.souzavaltenis.originaldesafio.util.GrafoUtil;

@RestController
@RequestMapping("/distance")
public class DistanciaController {
	
	@Autowired
	private GrafoService grafoService;

    @PostMapping
    public ResponseEntity<DistanciaDTO> obterDistancia(@RequestBody DistanciaDTO distanciaDTO){

    	Grafo grafo = DistanciaUtil.distanciaDTOParaGrafo(distanciaDTO);
    	List<String> caminho = distanciaDTO.getPath();
    	
    	DistanciaDTO distanciaCalculada = DistanciaUtil.calcularDistanciaDeUmCaminho(grafo, caminho);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(distanciaCalculada);
	}
    
    @PostMapping(value = "/{graphId}")
    public ResponseEntity<DistanciaDTO> obterDistancia(@PathVariable Integer graphId, @RequestBody DistanciaDTO distanciaDTO){
    	
    	Grafo grafo = grafoService.buscarPorId(graphId);
    	List<String> caminho = distanciaDTO.getPath();
    	
    	DistanciaDTO distanciaCalculada = DistanciaUtil.calcularDistanciaDeUmCaminho(grafo, caminho);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(distanciaCalculada);
	}
    
    @PostMapping(value = "/from/{town1}/to/{town2}")
    public ResponseEntity<DistanciaDTO> calcularDistanciaMinima(@PathVariable String town1, @PathVariable String town2, @RequestBody GrafoDTO grafoDTO){
    	
    	Grafo grafo = GrafoUtil.grafoDTOParaGrafo(grafoDTO);
    	
    	DistanciaDTO distanciaMinimaCalculada = DistanciaUtil.menorCaminho(grafo, town1, town2);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(distanciaMinimaCalculada);
	}
    
    @PostMapping(value = "/{graphId}/from/{town1}/to/{town2}")
    public ResponseEntity<DistanciaDTO> calcularDistanciaMinima(@PathVariable Integer graphId, @PathVariable String town1, @PathVariable String town2){
    	
    	Grafo grafo = grafoService.buscarPorId(graphId);
    	
    	DistanciaDTO distanciaMinimaCalculada = DistanciaUtil.menorCaminho(grafo, town1, town2);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(distanciaMinimaCalculada);
	}
}

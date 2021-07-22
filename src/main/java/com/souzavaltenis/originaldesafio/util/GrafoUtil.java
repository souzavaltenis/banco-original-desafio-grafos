package com.souzavaltenis.originaldesafio.util;

import java.util.List;

import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;

public class GrafoUtil {
	
	/*
	 * Conversão de uma DataDTO para um objeto Grafo.
	 * */
	public static Grafo grafoDTOParaGrafo(GrafoDTO data) {
		
    	List<ArestaDTO> arestas = data.getData();
    	Grafo grafo = new Grafo();
    	
    	VerticeUtil.adicionarVertices(grafo.getVertices(), arestas);
    	ArestaUtil.adicionarArestas(grafo, arestas);
    	
    	return grafo;
	}
	
	/*
	 * Conversão de um objeto Grafo para um GrafoDTO.
	 * */
	public static GrafoDTO grafoParaGrafoDTO(Grafo grafo) {
		List<ArestaDTO> arestasDTO = ArestaUtil.criarArestasDTO(grafo);
    	GrafoDTO grafoDTO = new GrafoDTO(grafo.getId(), arestasDTO);
    	return grafoDTO;
	}
}

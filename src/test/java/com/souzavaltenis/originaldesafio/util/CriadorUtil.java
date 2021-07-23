package com.souzavaltenis.originaldesafio.util;

import java.util.ArrayList;
import java.util.List;

import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;

public class CriadorUtil {

	/*
	 * Criação do grafo para realizar os casos de teste
	 * Grafo: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	 * */
	public static Grafo criarGrafo() {

    	List<ArestaDTO> arestas = new ArrayList<>();
    	
    	arestas.add(new ArestaDTO("A", "B", 5));
    	arestas.add(new ArestaDTO("B", "C", 4));
    	arestas.add(new ArestaDTO("C", "D", 8));
    	arestas.add(new ArestaDTO("D", "C", 8));
    	arestas.add(new ArestaDTO("D", "E", 6));
    	arestas.add(new ArestaDTO("A", "D", 5));
    	arestas.add(new ArestaDTO("C", "E", 2));
    	arestas.add(new ArestaDTO("E", "B", 3));
    	arestas.add(new ArestaDTO("A", "E", 7));
    	
    	Grafo grafo = new Grafo();
    	
    	VerticeUtil.adicionarVertices(grafo.getVertices(), arestas);
    	ArestaUtil.adicionarArestas(grafo, arestas);
		
		return grafo;
	}
}

package com.souzavaltenis.originaldesafio.util;

import java.util.ArrayList;
import java.util.List;

import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.model.Aresta;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.model.Vertice;

public class ArestaUtil {

    /*
     * Cria lista de Arestas DTO por meio de um modelo grafo.
     * */
    public static List<ArestaDTO> criarArestasDTO(Grafo grafo) {
    	
    	List<ArestaDTO> arestas = new ArrayList<>();

    	for(Aresta a : grafo.getArestas()) {
    		String source = a.getInicio().getDado();
			String target = a.getFim().getDado();
			Integer distance = a.getDistancia();
    		ArestaDTO arestaDTO = new ArestaDTO(source, target, distance);
    		arestas.add(arestaDTO);
    	}
    	
    	return arestas;
    }

    /*
     * Adiciona arestas que ainda não existem em um grafo 
     * por meio de uma lista de Arestas DTO.
     * */
    public static void adicionarArestas(Grafo grafo, List<ArestaDTO> arestas) {
    	for(ArestaDTO a : arestas) {
    		if(!contemAresta(grafo.getArestas(), a)) {
    			adicionarAresta(grafo, a.getSource(), a.getTarget(), a.getDistance());
    		}
    	}
    }
    
    /*
     * Verifica se uma arestaDTO pode ser adicionada as arestas de um grafo
     * com a condição de não possuir inicio, fim e distância iguais.
     * */
    public static boolean contemAresta(List<Aresta> arestas, ArestaDTO arestaDTO) {
    	
    	for(Aresta a : arestas) {
    		
    		String dadoInicio1 = a.getInicio().getDado();
    		String dadoFim1 = a.getFim().getDado();
    		Integer distancia1 = a.getDistancia();
    		
    		String dadoInicio2 = arestaDTO.getSource();
    		String dadoFim2 = arestaDTO.getTarget();
    		Integer distancia2 = arestaDTO.getDistance();
    		
    		if(dadoInicio1.equals(dadoInicio2) && dadoFim1.equals(dadoFim2) && distancia1 == distancia2) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    /*
     * Prepara e Adiciona uma aresta em um grafo.
     * */
	public static void adicionarAresta(Grafo grafo, String dadoInicio, String dadoFim, Integer distancia) {
		
		Vertice inicio = VerticeUtil.findVertice(grafo.getVertices(), dadoInicio);
		Vertice fim = VerticeUtil.findVertice(grafo.getVertices(), dadoFim);
		
		Aresta aresta = new Aresta(inicio, fim, distancia);
		
		inicio.getArestasSaida().add(aresta);
		fim.getArestasEntrada().add(aresta);
		
		grafo.getArestas().add(aresta);
	}
}

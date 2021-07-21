package com.souzavaltenis.originaldesafio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.model.Vertice;

@Service
public class VerticeService {
    
    /*
     * Adiciona vertices em um grafo por meio de uma lista de Arestas DTO.
     * Percorre todas arestas procurando por um vértice ainda não existente no grafo,
     * utilizando o vértice inicio e fim presente em uma aresta.
     * */
    public void adicionarVertices(List<Vertice> vertices, List<ArestaDTO> arestas) {
    	
    	for(ArestaDTO a : arestas) {
    		
    		Vertice inicio = new Vertice(a.getSource());
    		Vertice fim = new Vertice(a.getTarget());
    		
    		if(!containsVertice(vertices, inicio)) {
    			vertices.add(inicio);
    		}
    		if(!containsVertice(vertices, fim)) {
    			vertices.add(fim);
    		}
    	}
    }
    
    /*
     * Recebe uma lista de vertice e realiza uma busca por um vertice específico,
     * sendo essa pesquisa feita por meio do campo dado e não o objeto inteiro.
     * */
    public boolean containsVertice(List<Vertice> vertices, Vertice vertice) {
    	return vertices.stream().anyMatch(x -> x.getDado().equals(vertice.getDado()));
    }

    /*
     * Realiza uma busca de vértice na lista de vertice de um grafo utilizando o campo dado
     * presente no objeto Vertice retornando um objeto quando encontrar.
     * */
	public Vertice findVertice(List<Vertice> vertices, String dado){

		Vertice vertice = null;
		
		for(Vertice v : vertices) {
			if(v.getDado().equals(dado)) {
				vertice = v;
				break;
			}
		}

		return vertice;
	}
}

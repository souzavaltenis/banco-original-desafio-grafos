package com.souzavaltenis.originaldesafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzavaltenis.originaldesafio.dto.ArestaDTO;
import com.souzavaltenis.originaldesafio.model.Aresta;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.model.Vertice;
import com.souzavaltenis.originaldesafio.repository.ArestaRepository;

@Service
public class ArestaService {
	
    @Autowired
    private ArestaRepository repository;
    
    @Autowired
    private VerticeService verticeService;
    
    public Aresta insert(Aresta aresta) {
    	return repository.save(aresta);
    }
    
    /*
     * Cria lista de Arestas DTO por meio de um modelo grafo.
     * */
    public List<ArestaDTO> criarArestasDTO(Grafo grafo) {
    	
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
    public void adicionarArestas(Grafo grafo, List<ArestaDTO> arestas) {
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
    public boolean contemAresta(List<Aresta> arestas, ArestaDTO arestaDTO) {
    	
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
	public void adicionarAresta(Grafo grafo, String dadoInicio, String dadoFim, Integer distancia) {
		Vertice inicio = verticeService.findVertice(grafo.getVertices(), dadoInicio);
		Vertice fim = verticeService.findVertice(grafo.getVertices(), dadoFim);
		Aresta aresta = new Aresta(inicio, fim, distancia);
		inicio.getArestasSaida().add(aresta);
		fim.getArestasEntrada().add(aresta);
		grafo.getArestas().add(aresta);
		this.insert(aresta);
	}
    
}

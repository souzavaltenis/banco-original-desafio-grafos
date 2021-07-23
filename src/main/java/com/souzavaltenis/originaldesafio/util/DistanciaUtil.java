package com.souzavaltenis.originaldesafio.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.souzavaltenis.originaldesafio.dto.DistanciaDTO;
import com.souzavaltenis.originaldesafio.dto.GrafoDTO;
import com.souzavaltenis.originaldesafio.model.Aresta;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.model.Vertice;

public class DistanciaUtil {
	
	/*
	 * Pega um caminho e um grafo, verifica a distancia gasta parar percorrer-lo.
	 * */
	public static DistanciaDTO calcularDistanciaDeUmCaminho(Grafo grafo, List<String> caminho) {

    	Integer distancia = DistanciaUtil.calcularDistancia(grafo, caminho);
    	
    	DistanciaDTO distanciaCalculada = new DistanciaDTO(distancia);

		return distanciaCalculada;
	}

	/*
	 * A partir de um objeto DistanciaDTO, é extraido a lista de arestas para criar um Grafo.
	 * */
	public static Grafo distanciaDTOParaGrafo(DistanciaDTO distanciaDTO) {
		
		GrafoDTO grafoDTO = new GrafoDTO();
		grafoDTO.setData(distanciaDTO.getData());
		Grafo grafo = GrafoUtil.grafoDTOParaGrafo(grafoDTO);
		
		return grafo;
	}
	
    /*
     * Dado um grafo e um caminho específico, é realizado o calculo para descobrir a distância
     * total percorrida.
     * */
    public static Integer calcularDistancia(Grafo grafo, List<String> path) {
    	
    	if(path.isEmpty() || path.size() == 1) { //Lista de bairros vazia ou possua apenas 1 bairro
    		return 0;
    	}

    	LinkedList<Vertice> caminhoPesquisado = criarListaCaminho(grafo, path);

    	if(caminhoPesquisado == null) { //caminho não encontrado dentre os possíveis caminhos
    		return -1;
    	}
    	
    	Integer distanciaTotal = somarDistancias(caminhoPesquisado);
    	
    	return distanciaTotal;
    }
    
    /*
     * A partir de uma lista de string que representam os vértices, é realizado uma
     * busca no grafo para construir um caminho. No caso de não existir, retorna null.
     * */
    public static LinkedList<Vertice> criarListaCaminho(Grafo grafo, List<String> path){
    	
    	LinkedList<Vertice> caminho = new LinkedList<>();
    	Vertice origem = VerticeUtil.findVertice(grafo.getVertices(), path.get(0));
    	caminho.add(origem); //Inicia o caminho com a origem
    	path.remove(0); //Remove o primeiro pois já foi adicionado anteriormente
    	
    	for(String p : path) {
    		
    		Vertice ultimo = caminho.getLast();
    		Vertice proximo = VerticeUtil.findVertice(grafo.getVertices(), p);
			LinkedList<Vertice> verticesFinais = CaminhoUtil.proximosVertices(ultimo.getArestasSaida());

			//Verifica se os vértices finais das arestas do ultimo vértice 
			//não contém o próximo vértice a ser adicionado.
			//Em caso afirmativo, ele será um caminho inválido.
			if(!verticesFinais.contains(proximo)) { 
				return null;
			}
			
			caminho.add(proximo);
    	}

    	return caminho;
    }
    
    /*
     * Soma todas as distâncias das arestas presentes em um caminho.
     * */
    public static Integer somarDistancias(LinkedList<Vertice> caminhoPesquisado) {
    	
    	Integer totalDistancia = 0;
    	
    	for(int i=0; i<caminhoPesquisado.size()-1; i++) {
    		
    		Vertice v1 = caminhoPesquisado.get(i);
    		Vertice v2 = caminhoPesquisado.get(i+1);
    		
    		for(Aresta a : v1.getArestasSaida()) {
    			if(a.getFim().getDado().equals(v2.getDado())) {
    				totalDistancia += a.getDistancia();
    				break;
    			}
    		}
    		
    	}
    	
    	return totalDistancia;
    }
    
    /*
     * Dado um grafo e um ponto de origem e destino, é calculado a rota com menor distância.
     * Se a origem e destino forem iguais, retorna 0.
     * Se a origem e destino não possuirem um caminho entre eles, retorna -1.
     * */
    public static DistanciaDTO menorCaminho(Grafo grafo, String o, String d){
    	
    	if(o.equals(d)) { //Se origem for igual ao destino
    		return new DistanciaDTO(Arrays.asList(o), null, 0);
    	}
    	
    	List<LinkedList<Vertice>> caminhos = CaminhoUtil.obterCaminhos(grafo, o, d, null);
    	
    	if(caminhos.size() == 0) { //Se não existir caminho possível
    		return new DistanciaDTO(new ArrayList<String>(), null, -1);
    	}
    	
    	List<DistanciaDTO> distanciasDTO = gerarListaDistanciaDTO(caminhos);
    	
    	DistanciaDTO menorDistancia = distanciasDTO.stream().min((o1, o2) -> Integer.compare(o1.getDistance(), o2.getDistance())).get();
    	
    	return menorDistancia;
    }
    
    /*
     * Transforma uma lista de caminhos para uma lista de distanciaDTO.
     * */
    public static List<DistanciaDTO> gerarListaDistanciaDTO(List<LinkedList<Vertice>> caminhos){
    	
    	List<DistanciaDTO> distanciasDTO = new ArrayList<>();
    	
    	for(LinkedList<Vertice> c : caminhos) {
    		
    		DistanciaDTO distanciaDTO = new DistanciaDTO();
    		
    		List<String> path = caminhoParaListaStr(c);
    		Integer distance = somarDistancias(c);
    		
    		distanciaDTO.setPath(path);
    		distanciaDTO.setDistance(distance);
    		
    		distanciasDTO.add(distanciaDTO);
    	}
    	
    	return distanciasDTO;
    }
    
    /*
     * Com uma lista de vértice (um caminho), é realizado a criação de uma lista
     * de strings para salver apenas o nome de cada vértice.
     * */
    public static List<String> caminhoParaListaStr(LinkedList<Vertice> caminho){
    	
    	List<String> caminhosStr = new ArrayList<>();
    	
    	for(Vertice v : caminho) {
    		caminhosStr.add(v.getDado());
    	}
    	
    	return caminhosStr;
    }
    
}

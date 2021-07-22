package com.souzavaltenis.originaldesafio.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.souzavaltenis.originaldesafio.dto.CaminhoDTO;
import com.souzavaltenis.originaldesafio.dto.RoutesDTO;
import com.souzavaltenis.originaldesafio.model.Aresta;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.model.Vertice;

public class CaminhoUtil {
	
	
	/*
	 * Converte caminhos para uma Lista de CaminhoDTO e cria um objeto RoutesDTO
	 * */
	public static RoutesDTO caminhosParaDTO(List<LinkedList<Vertice>> caminhos) {
		
		List<CaminhoDTO> caminhosDTO = criarCaminhosDTO(caminhos);
		RoutesDTO routesDTO = new RoutesDTO(caminhosDTO);
		
		return routesDTO;
	}
	
	/*
	 * Dado uma lista de lista de caminhos, realiza a conversão para uma lista de
	 * CaminhoDTO, onde cada objeto segue os parâmetros: route, stops.
	 * */
	public static List<CaminhoDTO> criarCaminhosDTO(List<LinkedList<Vertice>> caminhos){
		
		List<CaminhoDTO> caminhosDTO = new ArrayList<>();
		
		for(LinkedList<Vertice> c : caminhos) {
			String route = concatenarCaminhos(c);
			Integer stops = c.size() - 1; //-1 pois não conta a origem de acordo com o exemplos dados
			CaminhoDTO caminhoDTO = new CaminhoDTO(route, stops);
			caminhosDTO.add(caminhoDTO);
		}
		
		return caminhosDTO;
	}
	
	/*
	 * Concatenação de caminho (nomes dos vertices) a partir de uma lista.
	 * */
	public static String concatenarCaminhos(LinkedList<Vertice> caminho) {
		
		String caminhoStr = "";
		
		for(Vertice v : caminho) {
			caminhoStr += v.getDado();
		}
		
		return caminhoStr;
	}
    
	/*
	 * Recebe um grafo e calcula todos os caminhos possíveis entre dois vértices utilizando como critério
	 * o número de parada máxima em caso de não ser nulo.
	 * */
    public static List<LinkedList<Vertice>> obterCaminhos(Grafo grafo, String o, String d, Integer paradasMaximas) {

    	Vertice origem = VerticeUtil.findVertice(grafo.getVertices(), o);
    	Vertice destino = VerticeUtil.findVertice(grafo.getVertices(), d);
    	
    	LinkedList<Vertice> visitados = new LinkedList<>();
    	visitados.add(origem); //Informa o ponto de partida na lista de visitados
        
        List<LinkedList<Vertice>> caminhos = new ArrayList<>();
        
        CaminhoUtil.buscaEmProfundidade(caminhos, visitados, destino);
        
        if(paradasMaximas != null) { //Caso existir limite de paradas, realiza a filtragem
        	caminhos.removeIf(c -> c.size() > paradasMaximas + 1); //+1 pois conta com a origem de acordo com o exemplos dados
        }
        
        return caminhos;
    }
	
	/*
	 * Realiza busca em profundidade para encontrar todos os caminhos possíveis entre dois vértices
	 * */
	public static void buscaEmProfundidade(List<LinkedList<Vertice>> caminhos, LinkedList<Vertice> visitados, Vertice destino) {
        
    	LinkedList<Vertice> nodes = proximosVertices(visitados.getLast().getArestasSaida());

        for (Vertice node : nodes) {
            if (visitados.contains(node)) {
                continue;
            }
            if (node.equals(destino)) {//Caminho encontrado
            	visitados.add(node);
                caminhos.add(new LinkedList<Vertice>(visitados)); //Salva um clone da lista que possui o caminho atual
                visitados.removeLast(); //Retrocede
                break;
            }
        }
        
        for (Vertice node : nodes) {
            if (visitados.contains(node) || node.equals(destino)) {
                continue;
            }
            visitados.addLast(node); //Se não visitado e não destino, adiciona nos visitados.
            buscaEmProfundidade(caminhos, visitados, destino);
            visitados.removeLast(); //Retrocede
        }
    }
    
    /*
     * Extrai uma lista dos próximos vértices a partir de uma lista de arestas de saida coletada de um vértice.
     * */
    private static LinkedList<Vertice> proximosVertices(List<Aresta> arestasSaida){
		
		LinkedList<Vertice> vertices = new LinkedList<>();
		
		for(Aresta a : arestasSaida) {
			vertices.add(a.getFim());
		}
		
		return vertices;
	}

}

package com.souzavaltenis.originaldesafio.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.souzavaltenis.originaldesafio.dto.RoutesDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.model.Vertice;
import com.souzavaltenis.originaldesafio.util.CaminhoUtil;

@Service
public class CaminhoService {
	
	public RoutesDTO criarRoutesDTO(Grafo grafo, String o, String d, Integer paradasMaximas) {
		List<LinkedList<Vertice>> caminhos = CaminhoUtil.obterCaminhos(grafo, o, d, paradasMaximas);
		RoutesDTO routesDTO = CaminhoUtil.caminhosParaDTO(caminhos);
		return routesDTO;
	}
}

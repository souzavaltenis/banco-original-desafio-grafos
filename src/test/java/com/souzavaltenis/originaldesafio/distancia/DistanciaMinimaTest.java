package com.souzavaltenis.originaldesafio.distancia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.souzavaltenis.originaldesafio.dto.DistanciaDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.util.CriadorUtil;
import com.souzavaltenis.originaldesafio.util.DistanciaUtil;

@ExtendWith(SpringExtension.class)
public class DistanciaMinimaTest {
	
	Grafo grafo = CriadorUtil.criarGrafo();

	@Test
	@DisplayName("Distância mínima de A para C: ABC (distância = 9)")
	public void casoDeTeste8() {

		String origem = "A";
		String destino = "C";
		
		List<String> rotaEsperada = new ArrayList<>(Arrays.asList("A", "B", "C"));
		int distanciaDaRotaEsperada = 9;
		
		DistanciaDTO caminhoEsperado = new DistanciaDTO(rotaEsperada, distanciaDaRotaEsperada);
		
		DistanciaDTO caminhoEncontrado = DistanciaUtil.menorCaminho(grafo, origem, destino);
		
		assertEquals(caminhoEsperado, caminhoEncontrado);
	}
	
	@Test
	@DisplayName("Distância mínima de B para B: B (distância = 0)")
	public void casoDeTeste9() {

		String origem = "B";
		String destino = "B";
		
		List<String> rotaEsperada = new ArrayList<>(Arrays.asList("B"));
		int distanciaDaRotaEsperada = 0;
		
		DistanciaDTO caminhoEsperado = new DistanciaDTO(rotaEsperada, distanciaDaRotaEsperada);
		
		DistanciaDTO caminhoEncontrado = DistanciaUtil.menorCaminho(grafo, origem, destino);
		
		assertEquals(caminhoEsperado, caminhoEncontrado);
	}
}

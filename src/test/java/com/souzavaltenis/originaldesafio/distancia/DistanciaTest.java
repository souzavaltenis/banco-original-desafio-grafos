package com.souzavaltenis.originaldesafio.distancia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.util.CriadorUtil;
import com.souzavaltenis.originaldesafio.util.DistanciaUtil;

@ExtendWith(SpringExtension.class)
public class DistanciaTest {
	
	Grafo grafo = CriadorUtil.criarGrafo();
	
	@Test
	@DisplayName("Distância da Rota ABC: 9")
	public void casoDeTeste1() {

		List<String> rota = new ArrayList<>(Arrays.asList("A", "B", "C"));
		
		int distanciaEsperada = 9;
		int distanciaEncontrada = DistanciaUtil.calcularDistancia(grafo, rota);
		
		assertEquals(distanciaEsperada, distanciaEncontrada);
	}

	@Test
	@DisplayName("Distância da Rota AD: 5")
	public void casoDeTeste2() {

		List<String> rota = new ArrayList<>(Arrays.asList("A", "D"));
		
		int distanciaEsperada = 5;
		int distanciaEncontrada = DistanciaUtil.calcularDistancia(grafo, rota);
		
		assertEquals(distanciaEsperada, distanciaEncontrada);
	}
	
	@Test
	@DisplayName("Distância da Rota ADC: 13")
	public void casoDeTeste3() {

		List<String> rota = new ArrayList<>(Arrays.asList("A", "D", "C"));
		
		int distanciaEsperada = 13;
		int distanciaEncontrada = DistanciaUtil.calcularDistancia(grafo, rota);
		
		assertEquals(distanciaEsperada, distanciaEncontrada);
	}
	
	@Test
	@DisplayName("Distância da Rota AEBCD: 22")
	public void casoDeTeste4() {

		List<String> rota = new ArrayList<>(Arrays.asList("A", "E", "B", "C", "D"));
		
		int distanciaEsperada = 22;
		int distanciaEncontrada = DistanciaUtil.calcularDistancia(grafo, rota);
		
		assertEquals(distanciaEsperada, distanciaEncontrada);
	}
	
	@Test
	@DisplayName("Distância da Rota AED: -1 (Inexistente)")
	public void casoDeTeste5() {

		List<String> rota = new ArrayList<>(Arrays.asList("A", "E", "D"));
		
		int distanciaEsperada = -1;
		int distanciaEncontrada = DistanciaUtil.calcularDistancia(grafo, rota);
		
		assertEquals(distanciaEsperada, distanciaEncontrada);
	}
}

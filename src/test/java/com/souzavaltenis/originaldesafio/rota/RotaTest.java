package com.souzavaltenis.originaldesafio.rota;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.souzavaltenis.originaldesafio.dto.CaminhoDTO;
import com.souzavaltenis.originaldesafio.model.Grafo;
import com.souzavaltenis.originaldesafio.util.CaminhoUtil;
import com.souzavaltenis.originaldesafio.util.CriadorUtil;

@ExtendWith(SpringExtension.class)
public class RotaTest {
	
	Grafo grafo = CriadorUtil.criarGrafo();
	
	@Test
	@DisplayName("Rotas de origem C e destino C com um máximo de 3 paradas: C (0 paradas)")
	public void casoDeTeste6() {
		
		String origem = "C";
		String destino = "C";
		int paradasMaximas = 3;
		
		List<CaminhoDTO> caminhosEsperado = new ArrayList<>();
		caminhosEsperado.add(new CaminhoDTO("C", 0));
		
		List<CaminhoDTO> caminhosEncontrado = CaminhoUtil.criarRoutesDTO(grafo, origem, destino, paradasMaximas).getRoutes();
		
		Assertions.assertIterableEquals(caminhosEsperado, caminhosEncontrado);
	}
	
	@Test
	@DisplayName("Rotas de origem A e destino C com um máximo de 4 paradas: ABC (2 paradas), ADC (2 paradas), AEBC (3 paradas), ADEBC (4 paradas)")
	public void casoDeTeste7() {
		
		String origem = "A";
		String destino = "C";
		int paradasMaximas = 4;
		
		List<CaminhoDTO> caminhosEsperado = new ArrayList<>();
		caminhosEsperado.add(new CaminhoDTO("ABC", 2));
		caminhosEsperado.add(new CaminhoDTO("ADC", 2));
		caminhosEsperado.add(new CaminhoDTO("AEBC", 3));
		caminhosEsperado.add(new CaminhoDTO("ADEBC", 4));
		caminhosEsperado.sort((o1, o2) -> o1.getRoute().compareTo(o2.getRoute()));
		
		List<CaminhoDTO> caminhosEncontrado = CaminhoUtil.criarRoutesDTO(grafo, origem, destino, paradasMaximas).getRoutes();
		caminhosEncontrado.sort((o1, o2) -> o1.getRoute().compareTo(o2.getRoute()));
		
		Assertions.assertIterableEquals(caminhosEsperado, caminhosEncontrado);
	}
}

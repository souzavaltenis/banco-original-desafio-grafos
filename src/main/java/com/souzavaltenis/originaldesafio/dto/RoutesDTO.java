package com.souzavaltenis.originaldesafio.dto;

import java.util.List;

public class RoutesDTO {

	private List<CaminhoDTO> routes;

	public RoutesDTO() {
		
	}

	public RoutesDTO(List<CaminhoDTO> routes) {
		super();
		this.routes = routes;
	}

	public List<CaminhoDTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<CaminhoDTO> routes) {
		this.routes = routes;
	}

}

package com.souzavaltenis.originaldesafio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
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

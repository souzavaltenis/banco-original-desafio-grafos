package com.souzavaltenis.originaldesafio.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RoutesDTO {

	private List<CaminhoDTO> routes;

	public RoutesDTO() {
		
	}

	public RoutesDTO(List<CaminhoDTO> routes) {
		this.routes = routes;
	}

	public List<CaminhoDTO> getRoutes() {
		return routes;
	}

	public void setRoutes(List<CaminhoDTO> routes) {
		this.routes = routes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(routes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoutesDTO other = (RoutesDTO) obj;
		return Objects.equals(routes, other.routes);
	}

}

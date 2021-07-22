package com.souzavaltenis.originaldesafio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CaminhoDTO {

	private String route;
	private Integer stops;

	public CaminhoDTO() {

	}

	public CaminhoDTO(String route, Integer stops) {
		this.route = route;
		this.stops = stops;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Integer getStops() {
		return stops;
	}

	public void setStops(Integer stops) {
		this.stops = stops;
	}

}

package com.souzavaltenis.originaldesafio.dto;

public class CaminhoDTO {

	private String route;
	private Integer stops;

	public CaminhoDTO() {

	}

	public CaminhoDTO(String route, Integer stops) {
		super();
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

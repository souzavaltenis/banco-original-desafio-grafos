package com.souzavaltenis.originaldesafio.dto;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(route, stops);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaminhoDTO other = (CaminhoDTO) obj;
		return Objects.equals(route, other.route) && Objects.equals(stops, other.stops);
	}

	@Override
	public String toString() {
		return "CaminhoDTO [route=" + route + ", stops=" + stops + "]";
	}

}

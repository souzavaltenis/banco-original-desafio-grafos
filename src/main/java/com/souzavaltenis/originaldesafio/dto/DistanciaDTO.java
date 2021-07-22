package com.souzavaltenis.originaldesafio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DistanciaDTO {
	
	private Integer distance;
	private List<String> path;
	private List<ArestaDTO> data;

	public DistanciaDTO() {

	}

	public DistanciaDTO(List<String> path, List<ArestaDTO> data, Integer distance) {
		this.path = path;
		this.data = data;
		this.distance = distance;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	public List<ArestaDTO> getData() {
		return data;
	}

	public void setData(List<ArestaDTO> data) {
		this.data = data;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

}

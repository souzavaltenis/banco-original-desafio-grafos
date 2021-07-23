package com.souzavaltenis.originaldesafio.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DistanciaDTO {
	
	private Integer distance;
	private List<String> path;
	private List<ArestaDTO> data;

	public DistanciaDTO() {

	}
	
	public DistanciaDTO(Integer distance) {
		this.distance = distance;
	}
	
	public DistanciaDTO(List<String> path, Integer distance) {
		this.path = path;
		this.distance = distance;
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

	@Override
	public int hashCode() {
		return Objects.hash(data, distance, path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistanciaDTO other = (DistanciaDTO) obj;
		return Objects.equals(data, other.data) && Objects.equals(distance, other.distance)
				&& Objects.equals(path, other.path);
	}

}

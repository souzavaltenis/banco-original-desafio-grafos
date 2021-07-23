package com.souzavaltenis.originaldesafio.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GrafoDTO {

	private Integer id;
	private List<ArestaDTO> data;

	public GrafoDTO() {

	}

	public GrafoDTO(Integer id, List<ArestaDTO> data) {
		this.id = id;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ArestaDTO> getData() {
		return data;
	}

	public void setData(List<ArestaDTO> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrafoDTO other = (GrafoDTO) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id);
	}

}

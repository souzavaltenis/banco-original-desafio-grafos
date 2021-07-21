package com.souzavaltenis.originaldesafio.dto;

import java.util.List;

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
	
}

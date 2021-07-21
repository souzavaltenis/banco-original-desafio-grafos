package com.souzavaltenis.originaldesafio.dto;

import java.util.List;

public class DataDTO {

	private List<ArestaDTO> data;

	public DataDTO() {
		
	}

	public DataDTO(List<ArestaDTO> data) {
		this.data = data;
	}

	public List<ArestaDTO> getData() {
		return data;
	}

	public void setData(List<ArestaDTO> data) {
		this.data = data;
	}

}

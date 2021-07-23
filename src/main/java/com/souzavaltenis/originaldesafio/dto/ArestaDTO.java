package com.souzavaltenis.originaldesafio.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ArestaDTO {

	private String source;
	private String target;
	private Integer distance;

	public ArestaDTO() {

	}

	public ArestaDTO(String source, String target, Integer distance) {
		this.source = source;
		this.target = target;
		this.distance = distance;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, source, target);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArestaDTO other = (ArestaDTO) obj;
		return Objects.equals(distance, other.distance) && Objects.equals(source, other.source)
				&& Objects.equals(target, other.target);
	}

}

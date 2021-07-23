package com.souzavaltenis.originaldesafio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

@Entity
public class Vertice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String dado;

	@OneToMany
	@Nullable
	private List<Aresta> arestasEntrada = new ArrayList<>();

	@OneToMany
	@Nullable
	private List<Aresta> arestasSaida = new ArrayList<>();

	public Vertice() {

	}

	public Vertice(String dado) {
		this.dado = dado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public List<Aresta> getArestasEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(List<Aresta> arestasEntrada) {
		this.arestasEntrada = arestasEntrada;
	}

	public List<Aresta> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestasSaida(List<Aresta> arestasSaida) {
		this.arestasSaida = arestasSaida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arestasEntrada, arestasSaida, dado, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return Objects.equals(arestasEntrada, other.arestasEntrada) && Objects.equals(arestasSaida, other.arestasSaida)
				&& Objects.equals(dado, other.dado) && Objects.equals(id, other.id);
	}

}

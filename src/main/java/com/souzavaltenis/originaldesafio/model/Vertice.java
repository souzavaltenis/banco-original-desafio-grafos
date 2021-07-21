package com.souzavaltenis.originaldesafio.model;

import java.util.ArrayList;
import java.util.List;

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
		super();
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
	public String toString() {
		return dado;
	}

}

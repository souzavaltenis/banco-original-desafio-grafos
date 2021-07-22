package com.souzavaltenis.originaldesafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aresta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private Vertice inicio;

	@OneToOne
	private Vertice fim;

	private Integer distancia;

	public Aresta() {

	}

	public Aresta(Integer id, Vertice inicio, Vertice fim, Integer distancia) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.distancia = distancia;
	}
	
	public Aresta(Vertice inicio, Vertice fim, Integer distancia) {
		this.inicio = inicio;
		this.fim = fim;
		this.distancia = distancia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vertice getInicio() {
		return inicio;
	}

	public void setInicio(Vertice inicio) {
		this.inicio = inicio;
	}

	public Vertice getFim() {
		return fim;
	}

	public void setFim(Vertice fim) {
		this.fim = fim;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	
}
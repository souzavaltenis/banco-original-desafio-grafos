package com.souzavaltenis.originaldesafio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Grafo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	private List<Vertice> vertices;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = true)
	private List<Aresta> arestas;

	public Grafo() {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arestas, id, vertices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafo other = (Grafo) obj;
		return Objects.equals(arestas, other.arestas) && Objects.equals(id, other.id)
				&& Objects.equals(vertices, other.vertices);
	}

}

package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prendas")
public class Prendas implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String tallas;
	
	@Column(nullable=false)
	private String sexo;
	
	@Column(nullable=false)
	private String prendas;
	
	@Column(nullable=false)
	private String color;
	
	@Column(nullable=false)
	private Integer precio;
	
	@Column(nullable=false)
	private Integer unidades;
	

	public Prendas() {
	}
	
	public Prendas(String nombre, String tallas, String sexo, String prendas, String color, Integer precio, Integer unidades) {
		this.nombre = nombre;
		this.tallas = tallas;
		this.sexo = sexo;
		this.prendas = prendas;
		this.color = color;
		this.precio = precio;
		this.unidades = unidades;
	}

	public Prendas(Integer id, String nombre, Integer precio, String sexo, String prendas, String color, String tallas, Integer unidades) {
		this(nombre, tallas, sexo, prendas, color, precio, unidades);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTallas() {
		return tallas;
	}

	public void setTallas(String tallas) {
		this.tallas = tallas;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPrendas() {
		return prendas;
	}

	public void setPrendas(String prendas) {
		this.prendas = prendas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	private static final long serialVersionUID = 1L;
}
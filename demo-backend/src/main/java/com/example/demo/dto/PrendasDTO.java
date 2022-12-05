package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import com.example.demo.utils.Constant;

public class PrendasDTO {

	private Integer id;
	@NotEmpty(message = Constant.NAME_REQUIRED)
	
	private String color;
	
	private String nombre;
	private Integer precio;
	private String prendas;
	private String sexo;
	private String tallas;
	private Integer unidades;
	
	
//	@NotEmpty(message = Constant.SURNAME1_REQUIRED)
//	private String surname1;
//	
//	@NotEmpty(message = Constant.SURNAME2_REQUIRED)
//	private String surname2;
//	
//	@NotNull(message = Constant.PHONE_REQUIRED)
//	private Integer phone;
//	
//	@Email(message= Constant.EMAIL_INVALID)
//	@NotEmpty(message = Constant.EMAIL_REQUIRED)
//	private String email;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public String getPrendas() {
		return prendas;
	}


	public void setPrendas(String prendas) {
		this.prendas = prendas;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTallas() {
		return tallas;
	}


	public void setTallas(String tallas) {
		this.tallas = tallas;
	}


	public Integer getUnidades() {
		return unidades;
	}


	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}




}

package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.utils.Constant;

public class PrendasDTO {

	private Integer id;
	@NotEmpty(message = Constant.NOMBRE_REQUIRED)
	private String nombre;

	@NotNull(message = Constant.PRECIO_REQUIRED)
	private Integer precio;
	
	@NotEmpty(message = Constant.COLOR_REQUIRED)
	private String color;

	@NotEmpty(message = Constant.PRENDAS_REQUIRED)
	private String prendas;

	@NotEmpty(message = Constant.SEXO_REQUIRED)
	private String sexo;

	@NotNull(message = Constant.TALLAS_REQUIRED)
	private String tallas;

	@NotNull(message = Constant.UNIDADES_REQUIRED)
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

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

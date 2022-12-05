package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.utils.Constant;

public class PrendasDTO {

	private Integer id;
	@NotEmpty(message = Constant.NAME_REQUIRED)
	private String nombre;
	
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




}

package com.example.demo.service;

import java.util.List;

import com.borjaglez.springify.repository.filter.impl.AnyPageFilter;
import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.PrendasDTO;
import com.example.demo.entity.Contact;
import com.example.demo.rest.response.DataSourceRESTResponse;

public interface IPrendasService {

	/**
	 * Obtiene un usuario de BDD con el id indicado.
	 * 
	 * @param id el id del usuario de la BDD.
	 * @return el usuario cuyo id sea el pasado por parámetros.
	 */
	PrendasDTO getPrendas(Integer id);

	/**
	 * Devuelve los usuarios que alguno de sus campos contenga la 'query'
	 * independientemente de las mayúsculas.
	 * 
	 * @param pageFilter filtro de la tabla
	 * @return usuarios que alguno de sus campos contenga la 'query'
	 *         independientemente de las mayúsculas.
	 * @since 0.0.5
	 */
	DataSourceRESTResponse<List<PrendasDTO>> getPrendas(AnyPageFilter pageFilter);

	/**
	 * Crea un nuevo usuario en la BDD.
	 * 
	 * @return el id del usuario creado.
	 * @since 0.0.5
	 */
	PrendasDTO createPrendas(PrendasDTO createPrendasRequest);


	/**
	 * Elimina un usuario de la BDD.
	 * 
	 * @return el id del usuario eliminado.
	 * @since 0.0.5
	 */
	Integer deletePrendas(Integer id);
	
	/**
	 * Devuelve todos los contactos que se encuentran en la tabla
	 * 
	 * @return usuarios que alguno de sus campos contenga la 'query'
	 *         independientemente de las mayúsculas.
	 * @since 0.0.5
	 */
	List<PrendasDTO> findAll();
	
	/**
	 * Modifica un usuario en la BDD.
	 * 
	 * @return el id del usuario modificado.
	 * @since 0.0.5
	 */
	Integer editPrendas(PrendasDTO editPrendasRequest);
	
}

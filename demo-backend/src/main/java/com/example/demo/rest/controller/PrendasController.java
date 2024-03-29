package com.example.demo.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.borjaglez.springify.repository.filter.impl.AnyPageFilter;
import com.example.demo.dto.PrendasDTO;
import com.example.demo.entity.enums.ResponseCodeEnum;
import com.example.demo.exception.DemoException;
import com.example.demo.rest.response.DataSourceRESTResponse;
import com.example.demo.service.IPrendasService;
import com.example.demo.utils.Constant;

@CrossOrigin(origins = { "http://localhost:4201" })
@RestController
@RequestMapping(PrendasController.REQUEST_MAPPING)
public class PrendasController {
	public static final String REQUEST_MAPPING = "prendas";
	private static final Logger LOGGER = LoggerFactory.getLogger(PrendasController.class);

	@Autowired
	private IPrendasService prendasService;

	/**
	 * Obtiene un contacto de BDD con el id indicado.
	 * 
	 * @param id el id del contacto de la BDD.
	 * @return el contacto cuyo id sea el pasado por parámetros.
	 */

	@GetMapping("/getPrenda")
	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public ResponseEntity<?> getPrendas(@RequestParam(value = "id") Integer id) {
		LOGGER.info("getPrenda in progress...");
		PrendasDTO prendas = null;
		Map<String, Object> response = new HashMap<>();
		ResponseEntity<?> re = null;
		try {
			prendas = prendasService.getPrendas(id);
			if (prendas == null) {
				response.put(Constant.MESSAGE, Constant.PRENDAS_NOT_EXISTS);
				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
				re = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			} else {
				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
				re = new ResponseEntity<>(prendas, HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			LOGGER.error(e.getMessage());
			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
			response.put(Constant.MESSAGE, Constant.DATABASE_QUERY_ERROR);
			response.put(Constant.ERROR, e.getMessage());
			re = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		LOGGER.info("getPrendas is finished...");
		return re;
	}



	/**
	 * Llamada REST para obtener usuarios que alguno de sus campos contenga la
	 * 'query' independientemente de las mayúsculas.
	 * 
	 * @return usuarios que alguno de sus campos contenga la 'query'
	 *         independientemente de las mayúsculas.
	 * @since 0.0.5
	 */
	@PostMapping(path = "/getPrendas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public @ResponseBody DataSourceRESTResponse<List<PrendasDTO>> getPrendas(@RequestBody AnyPageFilter pageFilter) {
		LOGGER.info("getPrendas in progress...");
		DataSourceRESTResponse<List<PrendasDTO>> dres = new DataSourceRESTResponse<>();
		try {
			dres = prendasService.getPrendas(pageFilter);

		} catch (DemoException e) {
			LOGGER.error(e.getMessage());
			dres.setResponseMessage(e.getMessage());
		}

		LOGGER.info("getPrendas is finished...");

		return dres;
	}

	/**
	 * Devuelve todos los contactos que se encuentran en la tabla
	 * 
	 * @return usuarios que alguno de sus campos contenga la 'query'
	 *         independientemente de las mayúsculas.
	 * @since 0.0.5
	 */
	@GetMapping(path = "/getPrendas")

	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public @ResponseBody List<PrendasDTO> findAll() {
		LOGGER.info("findAll in progress...");
		return prendasService.findAll();

	}

	/**
	 * Llamada REST para crear un nuevo usuario en la BDD.
	 * 
	 * @return el id del usuario creado.
	 * @since 0.0.5
	 */

	@PostMapping(path = "/createPrendas")
	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public ResponseEntity<?> createPrendas(@Valid @RequestBody PrendasDTO createPrendasRequest, BindingResult result) {
		LOGGER.info("createPrendas in progress...");
		PrendasDTO prendasNew = null;
		Map<String, Object> response = new HashMap<>();
		HttpStatus status = HttpStatus.CREATED;
		String message = Constant.PRENDAS_CREATE_SUCCESS;
		if (!result.hasErrors()) {
			try {
				prendasNew = prendasService.createPrendas(createPrendasRequest);
				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
			} catch (DataAccessException e) {
				if (e.getMostSpecificCause().getMessage().contains(Constant.PHONE_ERROR)) {
					message = Constant.PHONE_ALREADY_EXISTS;
					status = HttpStatus.OK;
				} else {
					message = Constant.DATABASE_QUERY_ERROR;
					status = HttpStatus.BAD_REQUEST;
				}

				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
				response.put(Constant.ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			}
			response.put("prendas", prendasNew);
		} else {
			List<String> errors = new ArrayList<>();
			for (FieldError error : result.getFieldErrors()) {
				errors.add(error.getDefaultMessage());
			}
			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.WARNING.getValue());
			message = Constant.PRENDAS_NOT_CREATED;
			response.put(Constant.ERROR, errors);
			status = HttpStatus.BAD_REQUEST;
		}

		LOGGER.info("createPrendas is finished...");
		response.put(Constant.MESSAGE, message);

		return new ResponseEntity<>(response, status);
	}


	/**
	 * Llamada REST para modificar un usuario en la BDD.
	 * 
	 * @return el id del usuario modificado.
	 * @since 0.0.5
	 */

	@PostMapping(path = "/editPrendas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public ResponseEntity<Map<String, Object>> editPrendas(@Valid @RequestBody PrendasDTO editPrendasRequest, BindingResult result) {
		LOGGER.info("editPrendas in progress...");
		int id = 0;
		PrendasDTO prendasOlder = prendasService.getPrendas(editPrendasRequest.getId());
		Map<String, Object> response = new HashMap<>();
		HttpStatus status = HttpStatus.CREATED;
		String message = Constant.PRENDAS_EDIT_SUCCESS;
		if (prendasOlder != null) {
			if (!result.hasErrors()) {
				try {
					id = prendasService.editPrendas(editPrendasRequest);
					response.put("prendasid", id);
					response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
				} catch (DataAccessException e) {
					if (e.getMostSpecificCause().getMessage().contains(Constant.PHONE_ERROR)) {
						message = Constant.PHONE_ALREADY_EXISTS;
						status = HttpStatus.OK;
					} else {
						message = Constant.DATABASE_QUERY_ERROR;
						status = HttpStatus.BAD_REQUEST;
					}
					response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
					response.put(Constant.ERROR,
							e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				}

			} else {
				List<String> errors = new ArrayList<>();
				for (FieldError error : result.getFieldErrors()) {
					errors.add(error.getDefaultMessage());
				}
				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.WARNING.getValue());
				message = Constant.PRENDAS_NOT_EDIT;
				response.put(Constant.ERROR, errors);
				status = HttpStatus.OK;
			}
		} else {
			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
			message = Constant.ID_NOT_EXISTS;
			status = HttpStatus.BAD_REQUEST;
		}

		response.put(Constant.MESSAGE, message);
		LOGGER.info("editPrendas is finished...");
		return new ResponseEntity<>(response, status);

	}



	/**
	 * Elimina un usuario de la BDD.
	 * 
	 * @return el id del usuario eliminado.
	 * @since 0.0.5
	 */

	@DeleteMapping("/deletePrendas")
	@PreAuthorize("hasAnyAuthority('PRENDAS')")
	public ResponseEntity<?> deletePrendas(@RequestParam(value = "id") Integer id) {
		LOGGER.info("deletePrendas in progress...");
		Map<String, Object> response = new HashMap<>();
		HttpStatus status = HttpStatus.OK;
		String message = Constant.PRENDAS_DELETE_SUCCESS;
		try {
			prendasService.deletePrendas(id);
			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
		} catch (DataAccessException e) {
			response.put(Constant.MESSAGE, Constant.DATABASE_QUERY_ERROR);
			response.put(Constant.ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
			status = HttpStatus.BAD_REQUEST;
			message = Constant.PRENDAS_NOT_DELETE;
		}
		response.put(Constant.MESSAGE, message);
		LOGGER.info("deletePrendas is finished...");
		return new ResponseEntity<>(response, status);
	}

}

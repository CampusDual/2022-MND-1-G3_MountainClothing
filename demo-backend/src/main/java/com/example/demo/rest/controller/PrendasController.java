package com.example.demo.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.borjaglez.springify.repository.filter.impl.AnyPageFilter;
import com.example.demo.dto.PrendasDTO;
import com.example.demo.exception.DemoException;
import com.example.demo.rest.response.DataSourceRESTResponse;
import com.example.demo.service.IPrendasService;

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

//	@GetMapping("/getContact")
//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
//	public ResponseEntity<?> getContact(@RequestParam(value = "id") Integer id) {
//		LOGGER.info("getContact in progress...");
//		ContactDTO contact = null;
//		Map<String, Object> response = new HashMap<>();
//		ResponseEntity<?> re = null;
//		try {
//			contact = prendasServices.getContact(id);
//			if (contact == null) {
//				response.put(Constant.MESSAGE, Constant.CONTACT_NOT_EXISTS);
//				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//				re = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//			} else {
//				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
//				re = new ResponseEntity<>(contact, HttpStatus.OK);
//			}
//		} catch (DataAccessException e) {
//			LOGGER.error(e.getMessage());
//			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//			response.put(Constant.MESSAGE, Constant.DATABASE_QUERY_ERROR);
//			response.put(Constant.ERROR, e.getMessage());
//			re = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//		}
//		LOGGER.info("getContact is finished...");
//		return re;
//	}



	/**
	 * Llamada REST para obtener usuarios que alguno de sus campos contenga la
	 * 'query' independientemente de las mayúsculas.
	 * 
	 * @return usuarios que alguno de sus campos contenga la 'query'
	 *         independientemente de las mayúsculas.
	 * @since 0.0.5
	 */
	@PostMapping(path = "/getPrendas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
	public @ResponseBody DataSourceRESTResponse<List<PrendasDTO>> getContacts(@RequestBody AnyPageFilter pageFilter) {
		LOGGER.info("getPrendas in progress...");
		DataSourceRESTResponse<List<PrendasDTO>> dres = new DataSourceRESTResponse<>();
		try {
			dres = prendasService.getPrendas(pageFilter);

		} catch (DemoException e) {
			LOGGER.error(e.getMessage());
			dres.setResponseMessage(e.getMessage());
		}

		LOGGER.info("getContacts is finished...");

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

//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
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

//	@PostMapping(path = "/createContact")
//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
//	public ResponseEntity<?> createContact(@Valid @RequestBody ContactDTO createContactRequest, BindingResult result) {
//		LOGGER.info("createContact in progress...");
//		ContactDTO contactNew = null;
//		Map<String, Object> response = new HashMap<>();
//		HttpStatus status = HttpStatus.CREATED;
//		String message = Constant.CONTACT_CREATE_SUCCESS;
//		if (!result.hasErrors()) {
//			try {
//				contactNew = prendasServices.createContact(createContactRequest);
//				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
//			} catch (DataAccessException e) {
//				if (e.getMostSpecificCause().getMessage().contains(Constant.PHONE_ERROR)) {
//					message = Constant.PHONE_ALREADY_EXISTS;
//					status = HttpStatus.OK;
//				} else {
//					message = Constant.DATABASE_QUERY_ERROR;
//					status = HttpStatus.BAD_REQUEST;
//				}
//
//				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//				response.put(Constant.ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//
//			}
//			response.put("contacto", contactNew);
//		} else {
//			List<String> errors = new ArrayList<>();
//			for (FieldError error : result.getFieldErrors()) {
//				errors.add(error.getDefaultMessage());
//			}
//			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.WARNING.getValue());
//			message = Constant.CONTACT_NOT_CREATED;
//			response.put(Constant.ERROR, errors);
//			status = HttpStatus.BAD_REQUEST;
//		}
//
//		LOGGER.info("createContact is finished...");
//		response.put(Constant.MESSAGE, message);
//
//		return new ResponseEntity<>(response, status);
//	}


	/**
	 * Llamada REST para modificar un usuario en la BDD.
	 * 
	 * @return el id del usuario modificado.
	 * @since 0.0.5
	 */

//	@PostMapping(path = "/editContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
//	public ResponseEntity<Map<String, Object>> editContact(@Valid @RequestBody ContactDTO editContactRequest, BindingResult result) {
//		LOGGER.info("editContact in progress...");
//		int id = 0;
//		ContactDTO contactOlder = prendasServices.getContact(editContactRequest.getId());
//		Map<String, Object> response = new HashMap<>();
//		HttpStatus status = HttpStatus.CREATED;
//		String message = Constant.CONTACT_EDIT_SUCCESS;
//		if (contactOlder != null) {
//			if (!result.hasErrors()) {
//				try {
//					id = prendasServices.editContact(editContactRequest);
//					response.put("contactid", id);
//					response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
//				} catch (DataAccessException e) {
//					if (e.getMostSpecificCause().getMessage().contains(Constant.PHONE_ERROR)) {
//						message = Constant.PHONE_ALREADY_EXISTS;
//						status = HttpStatus.OK;
//					} else {
//						message = Constant.DATABASE_QUERY_ERROR;
//						status = HttpStatus.BAD_REQUEST;
//					}
//					response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//					response.put(Constant.ERROR,
//							e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//				}
//
//			} else {
//				List<String> errors = new ArrayList<>();
//				for (FieldError error : result.getFieldErrors()) {
//					errors.add(error.getDefaultMessage());
//				}
//				response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.WARNING.getValue());
//				message = Constant.CONTACT_NOT_EDIT;
//				response.put(Constant.ERROR, errors);
//				status = HttpStatus.OK;
//			}
//		} else {
//			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//			message = Constant.ID_NOT_EXISTS;
//			status = HttpStatus.BAD_REQUEST;
//		}
//
//		response.put(Constant.MESSAGE, message);
//		LOGGER.info("editContact is finished...");
//		return new ResponseEntity<>(response, status);
//
//	}



	/**
	 * Elimina un usuario de la BDD.
	 * 
	 * @return el id del usuario eliminado.
	 * @since 0.0.5
	 */

//	@DeleteMapping("/deleteContact")
//	@PreAuthorize("hasAnyAuthority('CONTACTS')")
//	public ResponseEntity<?> deleteContact(@RequestParam(value = "id") Integer id) {
//		LOGGER.info("deleteContact in progress...");
//		Map<String, Object> response = new HashMap<>();
//		HttpStatus status = HttpStatus.OK;
//		String message = Constant.CONTACT_DELETE_SUCCESS;
//		try {
//			prendasServices.deleteContact(id);
//			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.OK.getValue());
//		} catch (DataAccessException e) {
//			response.put(Constant.MESSAGE, Constant.DATABASE_QUERY_ERROR);
//			response.put(Constant.ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			response.put(Constant.RESPONSE_CODE, ResponseCodeEnum.KO.getValue());
//			status = HttpStatus.BAD_REQUEST;
//			message = Constant.CONTACT_NOT_DELETE;
//		}
//		response.put(Constant.MESSAGE, message);
//		LOGGER.info("deleteContact is finished...");
//		return new ResponseEntity<>(response, status);
//	}

}

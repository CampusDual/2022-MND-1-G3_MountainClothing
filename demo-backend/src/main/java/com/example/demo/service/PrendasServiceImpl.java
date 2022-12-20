package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.borjaglez.springify.repository.filter.impl.AnyPageFilter;
import com.borjaglez.springify.repository.specification.SpecificationBuilder;
import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.PrendasDTO;
import com.example.demo.dto.mapper.ContactMapper;
import com.example.demo.dto.mapper.PrendasMapper;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Prendas;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.PrendasRepository;
import com.example.demo.rest.response.DataSourceRESTResponse;

@Service
public class PrendasServiceImpl extends AbstractDemoService implements IPrendasService {

	/**
	 * Especificación JPA para {@link Contact}.
	 */
	@Autowired
	private PrendasRepository prendasRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PrendasDTO getPrendas(Integer id) {
		Prendas prendas = prendasRepository.findById(id).orElse(null);
		return PrendasMapper.INSTANCE.prendasToPrendasDto(prendas);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public DataSourceRESTResponse<List<PrendasDTO>> getPrendas(AnyPageFilter pageFilter) {
		checkInputParams(pageFilter);
		Page<Prendas> prendas = SpecificationBuilder.selectDistinctFrom(prendasRepository).where(pageFilter)
				.findAll(pageFilter);
		DataSourceRESTResponse<List<PrendasDTO>> datares = new DataSourceRESTResponse<>();
		datares.setTotalElements((int) prendas.getTotalElements());
		List<PrendasDTO> prendasDtoList = PrendasMapper.INSTANCE.prendasToPrendasDtoList(prendas.getContent());
		datares.setData(prendasDtoList);
		return datares;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional

	public PrendasDTO createPrendas(PrendasDTO createPrendasRequestDTO) {
		Prendas newPrendas = PrendasMapper.INSTANCE.prendasDTOtoPrendas(createPrendasRequestDTO);
		Prendas prendas = prendasRepository.save(newPrendas);
		return PrendasMapper.INSTANCE.prendasToPrendasDto(prendas);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Integer deletePrendas(Integer id) {
		prendasRepository.deleteById(id);
		return id;

	}

	@Override
	public List<PrendasDTO> findAll() {

		List<Prendas> prendas = prendasRepository.findAll();
		return PrendasMapper.INSTANCE.prendasToPrendasDtoList(prendas);
	}


	@Override
	public Integer editPrendas(PrendasDTO editPrendasRequest) {
		Prendas prendas = PrendasMapper.INSTANCE.prendasDTOtoPrendas(editPrendasRequest);
		Prendas editPrendas = prendasRepository.save(fromEditPrendasRequest(prendas));
		return editPrendas.getId();
	}

}

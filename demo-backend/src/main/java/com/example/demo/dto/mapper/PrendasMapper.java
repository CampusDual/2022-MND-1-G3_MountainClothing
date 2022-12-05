package com.example.demo.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.PrendasDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Prendas;

@Mapper
public interface PrendasMapper {

    PrendasMapper INSTANCE = Mappers.getMapper( PrendasMapper.class );
 
    PrendasDTO prendasToPrendasDto(Prendas prendas);
    
    List<PrendasDTO> prendasToPrendasDtoList(List<Prendas> prendas);
    
    Prendas prendasDTOtoPrendas(PrendasDTO prendasdto);


}

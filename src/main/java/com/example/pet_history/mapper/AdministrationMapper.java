package com.example.pet_history.mapper;

import com.example.pet_history.dto.administration.AdministrationRequestDTO;
import com.example.pet_history.dto.administration.AdministrationResponseDTO;
import com.example.pet_history.entity.Administration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdministrationMapper {

    Administration toEntity(AdministrationRequestDTO dto);

    @Mapping(source = "medication.brandName", target = "brandName")
    AdministrationResponseDTO toDto(Administration entity);
}

package com.example.pet_history.mapper;

import com.example.pet_history.dto.pet.PetRequestDTO;
import com.example.pet_history.dto.pet.PetResponseDTO;
import com.example.pet_history.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toEntity(PetRequestDTO dto);

    @Mapping(source = "breed.species.name", target = "species")
    @Mapping(source = "breed.name", target = "breed")
    PetResponseDTO toDto(Pet entity);

    void updateFromDto(PetRequestDTO dto, @MappingTarget Pet entity);
}

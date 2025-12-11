package com.example.pet_history.mapper;

import com.example.pet_history.dto.test.TestRequestDTO;
import com.example.pet_history.dto.test.TestResponseDTO;
import com.example.pet_history.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {FileMapper.class})
public interface TestMapper {

    Test toEntity(TestRequestDTO testRequestDTO);

    void updateFromDto(TestRequestDTO dto, @MappingTarget Test entity);

    TestResponseDTO toDto(Test test);
}

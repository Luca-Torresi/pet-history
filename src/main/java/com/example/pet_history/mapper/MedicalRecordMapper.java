package com.example.pet_history.mapper;

import com.example.pet_history.dto.medication.MedicationRequestDTO;
import com.example.pet_history.dto.record.MedicalRecordRequestDTO;
import com.example.pet_history.dto.record.MedicalRecordResponseDTO;
import com.example.pet_history.entity.MedicalRecord;
import com.example.pet_history.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;

@Mapper(componentModel = "spring", uses ={VaccinationMapper.class, TreatmentMapper.class, TestMapper.class}, imports = {LocalDate.class})
public interface MedicalRecordMapper {

    MedicalRecordResponseDTO toDto(MedicalRecord entity);

    void updateFromDto(MedicalRecordRequestDTO dto, @MappingTarget MedicalRecord entity);

    @Mapping(source = "date", target = "date", defaultExpression = "java(LocalDate.now())")
    MedicalRecord toEntity(MedicalRecordRequestDTO dto);
}

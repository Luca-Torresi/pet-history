package com.example.pet_history.service;

import com.example.pet_history.dto.record.MedicalRecordRequestDTO;
import com.example.pet_history.dto.record.MedicalRecordResponseDTO;
import com.example.pet_history.entity.MedicalRecord;
import com.example.pet_history.entity.Pet;
import com.example.pet_history.exception.MedicalRecordNotFoundException;
import com.example.pet_history.exception.PetNotFoundException;
import com.example.pet_history.mapper.MedicalRecordMapper;
import com.example.pet_history.repository.MedicalRecordRepository;
import com.example.pet_history.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar la lógica de negocio los registros médicos.
 * Provee métodos para crear un nuevo registro médico, así como también para obtener todos los registro médicos asociados a una mascota o uno en particular.
 */

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;
    private final PetRepository petRepository;

    /**
     * Crea un nuevo registro médico asociado a una mascota.
     *
     * @param vetId ID del veterinario.
     * @param petId ID de la mascota.
     * @param dto Objeto DTO con la información correspondiente al registro médico.
     * @return El DTO de respuesta con los datos del registro médico recién creado.
     * @throws PetNotFoundException Si no se encuentra la mascota.
     */

    @Transactional
    public MedicalRecordResponseDTO createMedicalRecord(Long vetId, Long petId, MedicalRecordRequestDTO dto) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(()-> new PetNotFoundException(petId));

        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(dto);
        medicalRecord.setPet(pet);
        medicalRecord.setVetId(vetId);
        medicalRecordRepository.save(medicalRecord);

        return medicalRecordMapper.toDto(medicalRecord);
    }

    /**
     * Actualiza un registro médico existente asociado a una mascota.
     *
     * @param dto Objeto DTO con la información actualizada.
     * @return El DTO de respuesta con los datos del registro médico recién actualizado.
     * @throws MedicalRecordNotFoundException Si no se encuentra el registro médico.
     */

    @Transactional
    public MedicalRecordResponseDTO updateMedicalRecord(Long medicalRecordId, MedicalRecordRequestDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId)
                .orElseThrow(()-> new MedicalRecordNotFoundException(medicalRecordId));

        medicalRecordMapper.updateFromDto(dto, medicalRecord);
        medicalRecordRepository.save(medicalRecord);

        return medicalRecordMapper.toDto(medicalRecord);
    }

    /**
     * Obtiene todos los registros médicos asociados a una mascota.
     *
     * @param petId ID de la mascota.
     * @return Lista de DTOs, con la información de cada registro médico.
     * @throws PetNotFoundException Si no se encuentra la mascota.
     */

    public List<MedicalRecordResponseDTO> getRecordsByPetId(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(()-> new PetNotFoundException(petId));

        return pet.getMedicalRecords().stream()
                .map(medicalRecordMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene la información de un registro médico en particular.
     *
     * @param medicalRecordId ID del registro médico.
     * @return Objeto DTO con todos los datos del registro médico.
     * @throws MedicalRecordNotFoundException Si no se encuentra dicho registro médico.
     */

    public MedicalRecordResponseDTO getRecordById(Long medicalRecordId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId)
                .orElseThrow(() -> new MedicalRecordNotFoundException(medicalRecordId));

        return medicalRecordMapper.toDto(medicalRecord);
    }
}

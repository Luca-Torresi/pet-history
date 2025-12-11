package com.example.pet_history.service;

import com.example.pet_history.dto.administration.AdministrationRequestDTO;
import com.example.pet_history.dto.treatment.TreatmentRequestDTO;
import com.example.pet_history.dto.treatment.TreatmentResponseDTO;
import com.example.pet_history.entity.*;
import com.example.pet_history.exception.*;
import com.example.pet_history.mapper.AdministrationMapper;
import com.example.pet_history.mapper.TreatmentMapper;
import com.example.pet_history.repository.AdministrationRepository;
import com.example.pet_history.repository.MedicalRecordRepository;
import com.example.pet_history.repository.MedicationRepository;
import com.example.pet_history.repository.PetRepository;
import com.example.pet_history.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar la lógica de negocio de los tratamientos de las mascotas.
 * Provee métodos para crear, actualizar y consultar información de los tratamientos.
 */

@Service
@RequiredArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;
    private final MedicalRecordRepository medicalRecordRepository;
    private final PetRepository petRepository;
    private final MedicationRepository medicationRepository;
    private final AdministrationMapper administrationMapper;
    private final AdministrationRepository administrationRepository;

    /**
     * Registra un nuevo tratamiento con las administraciones asociadas a este.
     *
     * @param dto Objeto DTO con los datos para crear el nuevo tratamiento.
     * @return El DTO con la información de tratamiento recién creado.
     * @throws MedicalRecordNotFoundException Si no se encuentra el registro médico seleccionado.
     */

    public TreatmentResponseDTO registerNewTreatment(Long medicalRecordId, TreatmentRequestDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElseThrow(() -> new MedicalRecordNotFoundException(medicalRecordId));

        Treatment treatment = treatmentMapper.toEntity(dto);
        treatment.setMedicalRecord(medicalRecord);
        treatmentRepository.save(treatment);

        for(AdministrationRequestDTO administrationRequestDTO: dto.getAdministrations()){
            Medication medication = medicationRepository.findById(administrationRequestDTO.getMedicationId()).orElseThrow(() -> new MedicationNotFoundException(administrationRequestDTO.getMedicationId()));

            Administration administration = administrationMapper.toEntity(administrationRequestDTO);
            administration.setTreatment(treatment);
            administration.setMedication(medication);
            administrationRepository.save(administration);
        }

        return treatmentMapper.toDto(treatment);
    }

    /**
     * Actualiza un tratamiento existente.
     *
     * @param treatmentId ID del tratamiento a modificar.
     * @param dto Objeto DTO con los datos para actualizar el tratamiento.
     * @return El DTO con la información de tratamiento actualizado.
     * @throws TreatmentNotFoundException Si no se encuentra el tratamiento seleccionado.
     */

    public TreatmentResponseDTO updateTreatment(Long treatmentId, TreatmentRequestDTO dto) {
        Treatment treatment = treatmentRepository.findById(treatmentId).orElseThrow(() -> new TreatmentNotFoundException(treatmentId));

        treatmentMapper.updateFromDto(dto, treatment);
        treatmentRepository.save(treatment);
        return treatmentMapper.toDto(treatment);
    }

    /**
     * Obtiene todos los tratamientos recibidos por una mascota.
     *
     * @return Una lista de DTOs, donde se encuentra toda la información de cada tratamiento.
     * @throws PetNotFoundException Si no se encuentra la mascota seleccionado.
     */

    public List<TreatmentResponseDTO> getAllTreatmentsByPetId(Long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));

        return pet.getMedicalRecords().stream()
                .flatMap(medicalRecord -> medicalRecord.getTreatments().stream())
                .map(treatmentMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Registra la nueva administración de un medicamento.
     *
     * @param dto Objeto DTO con los datos para registrar la nueva administración.
     * @return El DTO con la información de tratamiento actualizado.
     * @throws TreatmentNotFoundException Si no se encuentra el tratamiento seleccionado.
     * @throws MedicalRecordNotFoundException Si no se encuentra el registro médico seleccionado.
     */

    public TreatmentResponseDTO addNewAdministration(Long treatmentId, AdministrationRequestDTO dto) {
        Treatment treatment = treatmentRepository.findById(treatmentId).orElseThrow(() -> new TreatmentNotFoundException(treatmentId));
        Medication medication = medicationRepository.findById(dto.getMedicationId()).orElseThrow(() -> new MedicationNotFoundException(dto.getMedicationId()));

        Administration administration = administrationMapper.toEntity(dto);
        administration.setMedication(medication);
        administration.setTreatment(treatment);
        administrationRepository.save(administration);

        treatment.getAdministrations().add(administration);
        treatmentRepository.save(treatment);

        return treatmentMapper.toDto(treatment);
    }
}

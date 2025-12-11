package com.example.pet_history.service;

import com.example.pet_history.dto.medication.MedicationRequestDTO;
import com.example.pet_history.dto.medication.MedicationResponseDTO;
import com.example.pet_history.entity.Medication;
import com.example.pet_history.exception.MedicationNotFoundException;
import com.example.pet_history.mapper.MedicationMapper;
import com.example.pet_history.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar los medicamentos.
 * Provee métodos para crear, actualizar y obtener un listado con todos los medicamentos.
 * Solo accesible para los administradores de la aplicación.
 */

@Service
@RequiredArgsConstructor
public class MedicationService {
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    /**
     * Registra un nuevo medicamento en el sistema.
     *
     * @param dto Objeto DTO con los datos para cargar el nuevo medicamento.
     * @return El DTO con la información del medicamento recién creado.
     */

    public MedicationResponseDTO createMedication(MedicationRequestDTO dto) {
        Medication medication = medicationMapper.toEntity(dto);
        medicationRepository.save(medication);
        return medicationMapper.toDto(medication);
    }

    /**
     * Acutaliza un medicamento existente en el sistema.
     *
     * @param medicationId ID del medicamento a modificar.
     * @param dto Objeto DTO con los datos para acutalizar el medicamento existente.
     * @return El DTO con la información del medicamento actualizado.
     * @throws MedicationNotFoundException Si no se encuentra dicho medicamento en el sistema.
     */

    public MedicationResponseDTO updateMedication(Long medicationId, MedicationRequestDTO dto) {
        Medication medication = medicationRepository.findById(medicationId).orElseThrow(() -> new MedicationNotFoundException(medicationId));

        medicationMapper.updateFromDto(dto, medication);
        medicationRepository.save(medication);
        return medicationMapper.toDto(medication);
    }

    /**
     * Devuelve una lista con todos los medicamentos.
     *
     * @return Lista con los DTOs que contienen la información de cada medicamento.
     */

    public List<MedicationResponseDTO> getAllMedications() {
        List<Medication> medications = medicationRepository.findAll();

        return medications.stream()
                .map(medicationMapper::toDto)
                .collect(Collectors.toList());
    }
}

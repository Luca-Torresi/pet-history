package com.example.pet_history.service;

import com.example.pet_history.dto.vaccination.VaccinationRequestDTO;
import com.example.pet_history.dto.vaccination.VaccinationResponseDTO;
import com.example.pet_history.entity.MedicalRecord;
import com.example.pet_history.entity.Pet;
import com.example.pet_history.entity.Vaccination;
import com.example.pet_history.entity.Vaccine;
import com.example.pet_history.enums.Status;
import com.example.pet_history.exception.*;
import com.example.pet_history.mapper.VaccinationMapper;
import com.example.pet_history.repository.MedicalRecordRepository;
import com.example.pet_history.repository.PetRepository;
import com.example.pet_history.repository.VaccinationRepository;
import com.example.pet_history.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar la lógica de negocio de las vacunaciones de las mascotas.
 * Provee métodos para regsitrar una nueva vacunación y consultar vacunaciones de las mascotas, tanto las vacunas aplicadas, como las pendientes.
 */

@Service
@RequiredArgsConstructor
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;
    private final VaccineRepository vaccineRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final VaccinationMapper vaccinationMapper;
    private final PetRepository petRepository;

    /**
     * Registra una nueva vacunación para una mascota.
     *
     * @param medicalRecordId ID del registro médico correspondiente.
     * @param dto Objeto DTO con los datos para registrar la nueva vacunación.
     * @return El DTO de respuesta de la vacunación.
     * @throws MedicalRecordNotFoundException Si no se encuentra el registro médico correspondiente.
     * @throws VaccineNotFoundException Si no se encuentra la vacuna seleccionada.
     */

    public VaccinationResponseDTO registerVaccination(Long medicalRecordId, VaccinationRequestDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElseThrow(()-> new MedicalRecordNotFoundException(medicalRecordId));
        Vaccine vaccine = vaccineRepository.findById(dto.getVaccineId()).orElseThrow(()-> new VaccineNotFoundException(dto.getVaccineId()));

        Vaccination vaccination = vaccinationMapper.toEntity(dto);
        vaccination.setMedicalRecord(medicalRecord);
        vaccination.setVaccine(vaccine);
        vaccinationRepository.save(vaccination);

        return vaccinationMapper.toDto(vaccination);
    }

    /**
     * Actualiza la información de una vacunación existente.
     *
     * @param vaccinationId ID de la vacunación correspondiente.
     * @param dto Objeto DTO con los datos para actualizar la vacunación.
     * @return El DTO de respuesta de la vacunación actualizada.
     * @throws VaccinationNotFoundException Si no se encuentra la vacunación seleccionada.
     */

    public VaccinationResponseDTO updateVaccination(Long vaccinationId, VaccinationRequestDTO dto) {
        Vaccination vaccination = vaccinationRepository.findById(vaccinationId).orElseThrow(() -> new VaccinationNotFoundException(vaccinationId));

        vaccinationMapper.updateFromDto(dto, vaccination);
        vaccinationRepository.save(vaccination);
        return vaccinationMapper.toDto(vaccination);
    }

    /**
     * Obtiene todas las vacunas aplicadas a una mascota.
     *
     * @return Una lista de DTOs con la información de cada vacunación aplicada.
     * @throws PetNotFoundException Si no se encuentra la mascota seleccionada.
     */

    public List<VaccinationResponseDTO> getVaccinations(Long petId) {
        Pet pet =  petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException(petId));

        return pet.getMedicalRecords().stream()
                .flatMap(medicalRecord -> medicalRecord.getVaccinations().stream())
                .map(vaccinationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene todas las vacunas pendientes de una mascota.
     *
     * @return Una lista de DTOs con la información de cada vacunación pendiente.
     * @throws PetNotFoundException Si no se encuentra la mascota seleccionada.
     */

    public List<VaccinationResponseDTO> getDueVaccinations(Long petId) {
        Pet pet =  petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException(petId));

        return pet.getMedicalRecords().stream()
                .flatMap(medicalRecord -> medicalRecord.getVaccinations().stream())
                .filter(vaccination -> vaccination.getStatus() == Status.PENDING)
                .map(vaccinationMapper::toDto)
                .collect(Collectors.toList());
    }
}

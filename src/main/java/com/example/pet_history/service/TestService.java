package com.example.pet_history.service;

import com.example.pet_history.dto.file.FileRequestDTO;
import com.example.pet_history.dto.file.FileResponseDTO;
import com.example.pet_history.dto.test.TestRequestDTO;
import com.example.pet_history.dto.test.TestResponseDTO;
import com.example.pet_history.entity.File;
import com.example.pet_history.entity.MedicalRecord;
import com.example.pet_history.entity.Test;
import com.example.pet_history.exception.MedicalRecordNotFoundException;
import com.example.pet_history.exception.TestNotFoundException;
import com.example.pet_history.mapper.FileMapper;
import com.example.pet_history.mapper.TestMapper;
import com.example.pet_history.repository.FileRepository;
import com.example.pet_history.repository.MedicalRecordRepository;
import com.example.pet_history.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Servicio para gestionar la lógica de negocio de los estudios de las mascotas.
 * Provee métodos para crear un nuevo estudio, obtener un estudio específico y subir un archivo correspondiente a un estudio.
 */

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final TestMapper testMapper;
    private final FileMapper fileMapper;
    private final FileRepository fileRepository;

    /**
     * Registra un nuevo estudio realizado a una mascota.
     *
     * @param medicalRecordId Id del registro médico en el cual se solicitó dicho estudio.
     * @param dto Objeto DTO con la información correspondiente al nuevo estudio.
     * @return El DTO del estudio guardado en el sistema.
     * @throws MedicalRecordNotFoundException Si no se encuentra el registro médico seleccionado.
     */

    public TestResponseDTO createTest(Long medicalRecordId, TestRequestDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElseThrow(()-> new MedicalRecordNotFoundException(medicalRecordId));

        Test test = testMapper.toEntity(dto);
        test.setMedicalRecord(medicalRecord);
        testRepository.save(test);

        return testMapper.toDto(test);
    }

    /**
     * Actualiza la información de un estudio seleccionado.
     *
     * @param testId Id del estudio.
     * @param dto Objeto DTO con la información actualizada del estudio.
     * @return El DTO con los datos del estudio actualizado.
     * @throws TestNotFoundException Si no se encuentra el estudio.
     */

    public TestResponseDTO updateTest(Long testId, TestRequestDTO dto) {
        Test test = testRepository.findById(testId).orElseThrow(()-> new TestNotFoundException(testId));

        testMapper.updateFromDto(dto, test);
        testRepository.save(test);
        return testMapper.toDto(test);
    }

    /**
     * Sube un nuevo archivo a la nube correspondiente a un estudio específico.
     *
     * @param testId Id del estudio.
     * @param dto Objeto DTO con la información correspondiente al archivo.
     * @param file Archivo adjunto.
     * @return El DTO con los datos del archivo subido en la nube.
     * @throws TestNotFoundException Si no se encuentra el estudio correspondiente.
     */

    public FileResponseDTO uploadFile(Long testId, FileRequestDTO dto, MultipartFile file) {
        Test test = testRepository.findById(testId).orElseThrow(()-> new TestNotFoundException(testId));

        File newFile = fileMapper.toEntity(dto);
        newFile.setTest(test);

        // Lógica para guardar el archivo en la nube
        // newFile.setFileName();
        // newFile.setStorageUrl();

        fileRepository.save(newFile);
        return fileMapper.toDto(newFile);
    }

    /**
     * Obtiene un estudio a través de su ID.
     *
     * @param testId Id del estudio.
     * @return El DTO con la información del estudio correspondiente.
     * @throws TestNotFoundException Si no se encuentra el estudio.
     */

    public TestResponseDTO getTestById(Long testId) {
        Test test = testRepository.findById(testId).orElseThrow(()-> new TestNotFoundException(testId));
        return testMapper.toDto(test);
    }
}

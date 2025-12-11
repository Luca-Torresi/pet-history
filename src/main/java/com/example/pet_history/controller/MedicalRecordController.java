package com.example.pet_history.controller;

import com.example.pet_history.dto.record.MedicalRecordRequestDTO;
import com.example.pet_history.dto.record.MedicalRecordResponseDTO;
import com.example.pet_history.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    @PostMapping("/{petId}")
    @PreAuthorize("hasRole('VETERINARIO')")
    public ResponseEntity<MedicalRecordResponseDTO> createMedicalRecord(
            @RequestHeader(value = "X-Vet-ID") Long vetId,
            @PathVariable Long petId,
            @Valid @RequestBody MedicalRecordRequestDTO dto) {
        return ResponseEntity.ok(medicalRecordService.createMedicalRecord(vetId, petId, dto));
    }

    @PutMapping("/{medicalRecordId}")
    @PreAuthorize("hasrole('VETERINARIO')")
    public ResponseEntity<MedicalRecordResponseDTO> updateMedicalRecord(
            @PathVariable Long medicalRecordId,
            @Valid @RequestBody MedicalRecordRequestDTO dto) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(medicalRecordId, dto));
    }

    @GetMapping("/pet/{petId}")
    @PreAuthorize("hasAnyRole('VETERINARIO','USUARIO')")
    public ResponseEntity<List<MedicalRecordResponseDTO>> getRecordsByPetId(
            @PathVariable Long petId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByPetId(petId));
    }

    @GetMapping("/{medicalRecordId}")
    @PreAuthorize("hasAnyRole('VETERINARIO','USUARIO')")
    public ResponseEntity<MedicalRecordResponseDTO> getRecordById(
            @PathVariable Long medicalRecordId) {
        return ResponseEntity.ok(medicalRecordService.getRecordById(medicalRecordId));
    }
}

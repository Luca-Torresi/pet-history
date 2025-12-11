package com.example.pet_history.controller;

import com.example.pet_history.dto.file.FileRequestDTO;
import com.example.pet_history.dto.file.FileResponseDTO;
import com.example.pet_history.dto.test.TestRequestDTO;
import com.example.pet_history.dto.test.TestResponseDTO;
import com.example.pet_history.service.TestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @PostMapping("{medicalRecordId}")
    public ResponseEntity<TestResponseDTO> createTest(
            @PathVariable("medicalRecordId") Long medicalRecordId,
            @Valid @RequestBody TestRequestDTO dto){
        return ResponseEntity.ok(testService.createTest(medicalRecordId, dto));
    }

    @PutMapping("/{testId}")
    public ResponseEntity<TestResponseDTO> updateTest(
            @PathVariable("testId") Long testId,
            @Valid @RequestBody TestRequestDTO dto) {
        return ResponseEntity.ok(testService.updateTest(testId, dto));
    }

    @PostMapping(value = "uploadFile/{testId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponseDTO> uploadFile(
            @PathVariable Long testId,
            @Valid @RequestPart("dto") FileRequestDTO dto,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(testService.uploadFile(testId, dto, file));
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestResponseDTO> getTestById(@PathVariable Long testId) {
        return ResponseEntity.ok(testService.getTestById(testId));
    }

}

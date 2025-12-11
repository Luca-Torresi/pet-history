package com.example.pet_history.controller;

import com.example.pet_history.dto.species.SpeciesRequestDTO;
import com.example.pet_history.dto.species.SpeciesResponseDTO;
import com.example.pet_history.service.SpeciesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SpeciesResponseDTO> newSpecies(
            @RequestPart("dto") String dtoString,
            @RequestParam(value = "image", required = false) MultipartFile image) throws JsonProcessingException {
        SpeciesRequestDTO dto = new ObjectMapper().readValue(dtoString, SpeciesRequestDTO.class);
        return ResponseEntity.ok(speciesService.newSpecies(dto, image));
    }

    @PutMapping(value = "/{speciesId}", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SpeciesResponseDTO> updateSpecies(
            @PathVariable Long speciesId,
            @RequestPart String dtoString,
            @RequestParam(value = "image", required = false)  MultipartFile image) throws JsonProcessingException {
        SpeciesRequestDTO dto = new ObjectMapper().readValue(dtoString, SpeciesRequestDTO.class);
        return ResponseEntity.ok(speciesService.updateSpecies(speciesId, dto, image));
    }

    @GetMapping
    public ResponseEntity<List<SpeciesResponseDTO>> getAllSpecies(){
        return ResponseEntity.ok(speciesService.getAllSpecies());
    }
}

package com.example.pet_history.dto.record;

import com.example.pet_history.dto.test.TestResponseDTO;
import com.example.pet_history.dto.treatment.TreatmentResponseDTO;
import com.example.pet_history.dto.vaccination.VaccinationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MedicalRecordResponseDTO {
    private Long id;
    private String reasonForVisit;
    private String notes;
    private LocalDate date;
    private List<VaccinationResponseDTO> vaccinations;
    private List<TreatmentResponseDTO> treatments;
    private List<TestResponseDTO> tests;
}

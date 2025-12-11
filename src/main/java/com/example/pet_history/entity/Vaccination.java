package com.example.pet_history.entity;

import com.example.pet_history.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Vaccination {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate applicationDate;
    private String lotNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;

    @ManyToOne @JoinColumn(name = "medicalRecordId")
    @ToString.Exclude
    private MedicalRecord medicalRecord;
}

package com.example.pet_history.entity;

import com.example.pet_history.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Treatment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne @JoinColumn(name = "medicalRecordId")
    @ToString.Exclude
    private MedicalRecord medicalRecord;

    @OneToMany(mappedBy = "treatment")
    private List<Administration> administrations;
}


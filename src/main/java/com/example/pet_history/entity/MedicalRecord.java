package com.example.pet_history.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class MedicalRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String reasonForVisit;
    private String notes;
    private Long vetId;

    @ManyToOne @JoinColumn(name = "petId")
    private Pet pet;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Test> tests;

}

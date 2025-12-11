package com.example.pet_history.entity;

import com.example.pet_history.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Test {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String results;
    private LocalDate testDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "test")
    private List<File> files;

    @ManyToOne @JoinColumn(name = "medicalRecordId")
    @ToString.Exclude
    private MedicalRecord medicalRecord;

}

package com.example.pet_history.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class File {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String storageUrl;
    private String type;
    private String description;

    @ManyToOne @JoinColumn(name = "testId")
    private Test test;
}

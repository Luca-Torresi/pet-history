package com.example.pet_history.repository;

import com.example.pet_history.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
}

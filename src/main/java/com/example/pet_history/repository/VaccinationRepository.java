package com.example.pet_history.repository;

import com.example.pet_history.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
}

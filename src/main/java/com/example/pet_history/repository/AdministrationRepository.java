package com.example.pet_history.repository;

import com.example.pet_history.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrationRepository extends JpaRepository<Administration,Long> {
}

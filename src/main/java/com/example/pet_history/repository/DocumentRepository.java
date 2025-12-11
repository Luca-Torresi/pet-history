package com.example.pet_history.repository;

import com.example.pet_history.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Test,Long> {
}

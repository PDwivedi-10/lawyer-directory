package com.legal.lawyer_directory.repository;

import com.legal.lawyer_directory.model.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
}
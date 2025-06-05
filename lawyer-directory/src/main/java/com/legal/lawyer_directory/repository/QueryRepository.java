package com.legal.lawyer_directory.repository;

import com.legal.lawyer_directory.model.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository extends JpaRepository<Query, Long> {
}
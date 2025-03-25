package com.cookmates.backend.repository;

import com.cookmates.backend.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}

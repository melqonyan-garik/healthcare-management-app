package com.epam.healthcaremanagementapp.repository;

import com.epam.healthcaremanagementapp.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}

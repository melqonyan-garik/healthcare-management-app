package com.epam.healthcaremanagementapp.repository;

import com.epam.healthcaremanagementapp.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}

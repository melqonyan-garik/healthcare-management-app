package com.epam.healthcaremanagementapp.service;
import com.epam.healthcaremanagementapp.model.Medication;
import com.epam.healthcaremanagementapp.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication prescribeMedication(Long medicationId) {
        return medicationRepository.findById(medicationId).orElse(null);
    }

    // Other medication-related business logic
}

package com.epam.healthcaremanagementapp.service;

import com.epam.healthcaremanagementapp.model.Medication;
import com.epam.healthcaremanagementapp.model.Patient;
import com.epam.healthcaremanagementapp.model.Prescription;
import com.epam.healthcaremanagementapp.repository.MedicationRepository;
import com.epam.healthcaremanagementapp.repository.PatientRepository;
import com.epam.healthcaremanagementapp.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;
    private final MedicationRepository medicationRepository;

    @Autowired
    public PrescriptionService(
            PrescriptionRepository prescriptionRepository,
            PatientRepository patientRepository,
            MedicationRepository medicationRepository
    ) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.medicationRepository = medicationRepository;
    }

    public Prescription prescribeMedication(Long patientId, Long medicationId, Prescription prescription) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Medication> medicationOptional = medicationRepository.findById(medicationId);

        if (patientOptional.isPresent() && medicationOptional.isPresent()) {
            Patient patient = patientOptional.get();
            Medication medication = medicationOptional.get();

            prescription.setPatient(patient);
            prescription.setMedication(medication);
            prescription.setPrescriptionDate(LocalDate.now());

            return prescriptionRepository.save(prescription);
        } else {
            // Handle patient or medication not found error
            return null;
        }
    }

    // Other prescription-related business logic
}
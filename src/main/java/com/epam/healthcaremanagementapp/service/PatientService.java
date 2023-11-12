package com.epam.healthcaremanagementapp.service;

import com.epam.healthcaremanagementapp.model.Appointment;
import com.epam.healthcaremanagementapp.model.Patient;
import com.epam.healthcaremanagementapp.repository.AppointmentRepository;
import com.epam.healthcaremanagementapp.repository.PatientRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public PatientService(
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository
    ) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    // Methods for retrieving patient information

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    // Methods for scheduling appointments

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment scheduleAppointment(Long patientId, Appointment newAppointment) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            newAppointment.setPatient(patient);
            return appointmentRepository.save(newAppointment);
        } else {
            // Handle patient not found error
            return null;
        }
    }

    // Other patient-related business logic
}
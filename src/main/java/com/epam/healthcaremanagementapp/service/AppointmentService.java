package com.epam.healthcaremanagementapp.service;

import com.epam.healthcaremanagementapp.model.Appointment;
import com.epam.healthcaremanagementapp.model.Patient;
import com.epam.healthcaremanagementapp.repository.AppointmentRepository;
import com.epam.healthcaremanagementapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository
    ) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
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

    // Other appointment-related business logic
}
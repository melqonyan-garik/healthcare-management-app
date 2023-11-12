package com.epam.healthcaremanagementapp.controller;

import com.epam.healthcaremanagementapp.model.Appointment;
import com.epam.healthcaremanagementapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/schedule/{patientId}")
    public ResponseEntity<Appointment> scheduleAppointment(
            @PathVariable Long patientId,
            @RequestBody Appointment newAppointment
    ) {
        Appointment scheduledAppointment = appointmentService.scheduleAppointment(patientId, newAppointment);

        if (scheduledAppointment != null) {
            return new ResponseEntity<>(scheduledAppointment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
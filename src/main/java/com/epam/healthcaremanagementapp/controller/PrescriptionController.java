package com.epam.healthcaremanagementapp.controller;
import com.epam.healthcaremanagementapp.model.Prescription;
import com.epam.healthcaremanagementapp.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/prescribe/{patientId}/{medicationId}")
    public ResponseEntity<Prescription> prescribeMedication(
            @PathVariable Long patientId,
            @PathVariable Long medicationId,
            @RequestBody Prescription prescription
    ) {
        Prescription prescribedMedication = prescriptionService.prescribeMedication(patientId, medicationId, prescription);

        if (prescribedMedication != null) {
            return new ResponseEntity<>(prescribedMedication, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
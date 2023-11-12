package com.epam.healthcaremanagementapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Other medication attributes, such as dosage and instructions

    // Constructors, getters, and setters
}
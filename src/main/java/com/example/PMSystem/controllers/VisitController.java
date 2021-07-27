package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Patients;
import com.example.PMSystem.model.Visits;
import com.example.PMSystem.repositories.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class VisitController {

    @Autowired
    public PatientRepository patientRepository;

    @PostMapping("/patient/{id}/add-comment")
    public String createVisit(@RequestBody Visits visits, @PathVariable("id") @NotNull int patientId){
        Patients patient = patientRepository.findById(patientId);
        visits.setCreatedDate(new Date());
        patient.getVisits().add(visits);
        return "Successfully created";
    }
}

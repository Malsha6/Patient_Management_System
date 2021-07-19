package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Patients;
import com.example.PMSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    public PatientRepository patientRepository;

    @GetMapping (value = "/patient/all")
    public List<Patients> getAllPatients(){ return patientRepository.findAll(); }

    @PostMapping(value = "/patient/create")
    public String createPatient(@RequestBody Patients patient){
        long patientCount = patientRepository.count();
        patient.setId(patientCount+1);
        patient.setCreatedDate(new Date());
        patient.setUpdatedDte(new Date());
        Patients insertedPatient = patientRepository.insert(patient);
        return "Successfully Created Patient";
    }



}

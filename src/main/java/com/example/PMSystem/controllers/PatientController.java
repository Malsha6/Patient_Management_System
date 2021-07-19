package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Patients;
import com.example.PMSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/patient/{id}")
    public Patients getPatient(String id){
        return patientRepository.findById(id);
    }

}

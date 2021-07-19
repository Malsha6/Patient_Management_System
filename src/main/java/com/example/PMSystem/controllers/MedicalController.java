package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Medicals;
import com.example.PMSystem.model.Patients;
import com.example.PMSystem.repositories.MedicalRepository;
import com.example.PMSystem.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MedicalController {

    @Autowired
    public MedicalRepository medicalRepository;

    @GetMapping(value = "/medical/all")
    public List<Medicals> getAllMedicals(){
        return medicalRepository.findAll();
    }

    @PostMapping(value = "/medical/create")
    public String createMedical(@RequestBody Medicals medicals){
        long medicalCount = medicalRepository.count();
        medicals.setId(medicalCount+1);
        medicals.setCreatedDate(new Date());
        medicals.setUpdatedDte(new Date());
        Medicals insertedPatient = medicalRepository.insert(medicals);
        return "Successfully Created Medical";
    }
}

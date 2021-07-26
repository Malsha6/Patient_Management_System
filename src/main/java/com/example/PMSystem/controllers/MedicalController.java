package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Medicals;
import com.example.PMSystem.model.Patients;
import com.example.PMSystem.repositories.MedicalRepository;
import com.example.PMSystem.repositories.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/medical/{id}")
    public Medicals getMedicaltbyId(@PathVariable("id") @NotNull int id){
        return medicalRepository.findById(id);
    }

    @GetMapping("/medical/findbyname")
    public List<Medicals> getMedicalbyName(@RequestParam("name") String name){
        return medicalRepository.findByName(name);
    }

//    @GetMapping("/medical/findbynic")
//    public List<Medicals> getMedicalbyNIC(@RequestParam("nic") String nic){
//        return medicalRepository.findByNic(nic);
//    }

    @DeleteMapping("/medical/{id}")
    public String deletebyId(@PathVariable("id") @NotNull int id){
        medicalRepository.deleteById(id);
        return "Successfully Deleted";
    }

    @PutMapping("/medical/{id}")
    public String updatebyId(@PathVariable("id") @NotNull int id, @RequestBody Medicals updateMedical){
        Medicals existingMedical = medicalRepository.findById(id);
        existingMedical.setName(updateMedical.getName());
        existingMedical.setAge(updateMedical.getAge());
        existingMedical.setDob(updateMedical.getDob());
        existingMedical.setFromDate(updateMedical.getFromDate());
        existingMedical.setCreatedDate(updateMedical.getCreatedDate());
        existingMedical.setUpdatedDte(new Date());
        medicalRepository.save(existingMedical);
        return "Successfully Updated";
    }
}

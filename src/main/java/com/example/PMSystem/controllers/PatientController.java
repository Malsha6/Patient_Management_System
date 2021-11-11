package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Patients;
import com.example.PMSystem.repositories.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

    @Autowired
    public PatientRepository patientRepository;

    @GetMapping (value = "/patient/all")
    public List<Patients> getAllPatients(){ return patientRepository.findAll((Sort.by(Sort.Direction.DESC, "_id"))); }

    @PostMapping(value = "/patient/create")
    public String createPatient(@RequestBody Patients patient){
        long patientCount = patientRepository.count();
        patient.setId((int) (patientCount+1));
        patient.setCreatedDate(new Date());
        patient.setUpdatedDte(new Date());
        Patients insertedPatient = patientRepository.insert(patient);
        return "Successfully Created Patient";
    }

    @GetMapping("/patient/{id}")
    public Patients getPatientbyId(@PathVariable("id") @NotNull int id){
        return patientRepository.findById(id);
    }

    @GetMapping("/patient/findbyname")
    public List<Patients> getPatientbyName(@RequestParam("name") String name){
        return patientRepository.findByName(name);
    }

    @GetMapping("/patient/findbynic")
    public List<Patients> getPatientbyNIC(@RequestParam("nic") String nic){
        return patientRepository.findByNic(nic);
    }

    @DeleteMapping("/patient/{id}")
    public void deletebyId(@PathVariable("id") @NotNull int id){
        patientRepository.deleteById(id);
        System.out.println("Deleted Successfully");
    }

    @PutMapping("/patient/{id}")
    public String updatebyId(@PathVariable("id") @NotNull int id, @RequestBody Patients updatePatient){
        Patients existingPatient = patientRepository.findById(id);
        existingPatient.setName(updatePatient.getName());
        existingPatient.setAge(updatePatient.getAge());
        existingPatient.setNic(updatePatient.getNic());
        existingPatient.setContact(updatePatient.getContact());
        existingPatient.setDob(updatePatient.getDob());
        existingPatient.setAddress(updatePatient.getAddress());
        existingPatient.setAllergies(updatePatient.getAllergies());
        existingPatient.setMedicines(updatePatient.getMedicines());
        existingPatient.setUpdatedDte(new Date());
        patientRepository.save(existingPatient);
        return "Successfully Updated";
    }

}

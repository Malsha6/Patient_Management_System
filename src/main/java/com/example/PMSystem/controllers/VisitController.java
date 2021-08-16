package com.example.PMSystem.controllers;

import com.example.PMSystem.model.Patients;
import com.example.PMSystem.model.Visits;
import com.example.PMSystem.repositories.PatientRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class VisitController {

    @Autowired
    public PatientRepository patientRepository;

    @GetMapping("/patient/{id}/visits")
    public List<Visits> findAllVisits(@PathVariable("id") final int ticketId){
        Patients patientObj = patientRepository.findById(ticketId);
        return patientObj.getVisits();
    }

    @PostMapping("/patient/{id}/visits")
    public String addVisits(@PathVariable("id") final int ticketId, @RequestBody Visits visits){
        Patients patientObj = patientRepository.findById(ticketId);
        int count = patientObj.getVisits().size();
        count+=1;
        visits.setId(count);
        visits.setCreatedDate(new Date());
        visits.setUpdatedDate(new Date());
        List<Visits> existingVisits = patientObj.getVisits();
        existingVisits.add(visits);
        patientObj.setVisits(existingVisits);
//        patientObj.setVisits(Collections.singletonList(visits));
        patientRepository.save(patientObj);
        return "Successfully Created Visit";
    }

    @GetMapping("/patient/{id}/visits/{visitid}")
    public Visits findSingleVisit(@PathVariable("id") final int patientId , @PathVariable("visitid") final int visitId){
        Patients patientObj = patientRepository.findById(patientId);
        List<Visits> allVisits = patientObj.getVisits();
        for (Visits visit : allVisits){
            if (visit.getId() == visitId) {
                return visit;
            }
        }
        return null;
    }

    @DeleteMapping("/patient/{id}/visits/{visitid}")
    public String deleteSingleVisit(@PathVariable("id") final int patientId , @PathVariable("visitid") final int visitId){
        Patients patientObj = patientRepository.findById(patientId);
        List<Visits> allVisits = patientObj.getVisits();
        for (Visits visit : allVisits){
            if (visit.getId() == visitId) {
                allVisits.remove(visit);
                patientObj.setVisits(allVisits);
                patientRepository.save(patientObj);
                return "Successfully Removed Visit";
            }
        }
        return null;
    }

    @PutMapping("/patient/{id}/visits/{visitid}")
    public String updateSingleVisit(@PathVariable("id") final int patientId , @PathVariable("visitid") final int visitId, @RequestBody Visits visits){
        Patients patientObj = patientRepository.findById(patientId);
        List<Visits> allVisits = patientObj.getVisits();
        for (Visits visit : allVisits){
            if (visit.getId() == visitId) {
                allVisits.remove(visit);
                visits.setUpdatedDate(new Date());
                allVisits.add(visits);
                patientObj.setVisits(allVisits);
                patientRepository.save(patientObj);
                return "Successfully Updated Visit";
            }
        }
        return null;
    }
}

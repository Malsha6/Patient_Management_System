package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patients, Integer> {

    Patients findById(int id);
    List <Patients> findByName(String name);
    List <Patients> findByNic(String nic);
}

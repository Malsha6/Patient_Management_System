package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patients, String> {
//    Optional<Patients> findById(String id);
    Patients findById(String id);
}

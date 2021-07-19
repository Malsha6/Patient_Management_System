package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PatientRepository extends MongoRepository<Patients, Long> {
}

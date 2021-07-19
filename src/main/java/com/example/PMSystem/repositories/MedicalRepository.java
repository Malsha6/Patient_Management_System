package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Medicals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRepository extends MongoRepository<Medicals,Long> {
}

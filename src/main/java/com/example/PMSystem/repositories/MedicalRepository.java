package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Medicals;
import com.example.PMSystem.model.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRepository extends MongoRepository<Medicals,Integer> {
    Medicals findById(int id);
    List<Medicals> findByName(String name);
//    List <Medicals> findByNic(String nic);
}

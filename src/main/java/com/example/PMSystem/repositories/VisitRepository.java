package com.example.PMSystem.repositories;

import com.example.PMSystem.model.Visits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends MongoRepository<Visits, Integer> {
}

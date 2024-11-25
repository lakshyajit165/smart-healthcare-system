package com.hungrycoders.repository;

import com.hungrycoders.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor, String> {
    // Custom query methods (optional)
    Optional<Doctor> findByEmail(String email);
}
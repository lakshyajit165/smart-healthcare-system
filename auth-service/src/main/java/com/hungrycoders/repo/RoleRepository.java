package com.hungrycoders.repo;

import com.hungrycoders.models.ERole;
import com.hungrycoders.models.Role;
import com.hungrycoders.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

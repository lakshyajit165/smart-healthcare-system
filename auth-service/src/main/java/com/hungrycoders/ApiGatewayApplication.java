package com.hungrycoders;

import com.hungrycoders.models.ERole;
import com.hungrycoders.models.Role;
import com.hungrycoders.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role(ERole.ROLE_ADMIN);
        roleRepository.save(admin);
        Role user = new Role(ERole.ROLE_USER);
        roleRepository.save(user);
        Role mod = new Role(ERole.ROLE_MODERATOR);
        roleRepository.save(mod);

    }
}

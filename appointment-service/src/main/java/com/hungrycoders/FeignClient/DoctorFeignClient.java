package com.hungrycoders.FeignClient;

import com.hungrycoders.DTO.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:8081/doctor")
public interface DoctorFeignClient {
    @GetMapping("/{id}")
    ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("id") String id);
}

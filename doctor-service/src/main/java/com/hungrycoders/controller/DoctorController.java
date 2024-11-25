package com.hungrycoders.controller;

import com.hungrycoders.DTO.DoctorDTO;
import com.hungrycoders.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable String id) throws Exception {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/all")
    public List<DoctorDTO> getAllDoctors() throws Exception {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/")
    public DoctorDTO save(@RequestBody  DoctorDTO doctorDTO) throws Exception {
        return doctorService.addDoctor(doctorDTO);
    }
}

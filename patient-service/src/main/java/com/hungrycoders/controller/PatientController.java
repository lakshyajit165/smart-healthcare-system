package com.hungrycoders.controller;

import com.hungrycoders.DTO.PatientDTO;
import com.hungrycoders.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable String id) throws Exception {
        return patientService.getPatientById(id);
    }

    @GetMapping("/all")
    public List<PatientDTO> getAllPatients() throws Exception {
        return patientService.getAllPatients();
    }

    @PostMapping("/")
    public PatientDTO save(@RequestBody  PatientDTO patientDTO) throws Exception {
        return patientService.addPatient(patientDTO);
    }
}

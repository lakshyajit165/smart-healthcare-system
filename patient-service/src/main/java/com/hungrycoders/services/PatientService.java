package com.hungrycoders.services;

import com.hungrycoders.DTO.PatientDTO;
import com.hungrycoders.exception.ResourceNotFoundException;
import com.hungrycoders.model.Patient;
import com.hungrycoders.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepository;

    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PatientDTO addPatient(PatientDTO patient) throws Exception {
        Optional<Patient> optionalPatient = patientRepository.findByFirstNameAndLastNameAndEmail(patient.getFirstName(), patient.getLastName(), patient.getEmail());
        if(!optionalPatient.isEmpty()) {
            throw new Exception("Patient already exists");
        }
        Patient p1= patientRepository.save(this.toModel(patient));
        return this.toDTO(p1);
    }

    public PatientDTO getPatientById(String id) throws ResourceNotFoundException {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isEmpty()) {
            throw new ResourceNotFoundException("Patient details not found!");
        }
        return this.toDTO(optionalPatient.get());
    }

    private PatientDTO toDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        dto.setPhone(patient.getPhone());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setBloodType(patient.getBloodType());
        dto.setGuardianName(patient.getGuardianName());
        return dto;
    }

    private Patient toModel(PatientDTO patient) {
        Patient model = new Patient();
        model.setId(patient.getId());
        model.setFirstName(patient.getFirstName());
        model.setLastName(patient.getLastName());
        model.setDateOfBirth(patient.getDateOfBirth());
        model.setGender(patient.getGender());
        model.setPhone(patient.getPhone());
        model.setEmail(patient.getEmail());
        model.setAddress(patient.getAddress());
        model.setBloodType(patient.getBloodType());
        model.setGuardianName(patient.getGuardianName());
        return model;
    }
}



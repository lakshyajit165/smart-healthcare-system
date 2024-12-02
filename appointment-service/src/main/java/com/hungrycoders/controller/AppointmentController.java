package com.hungrycoders.controller;

import com.hungrycoders.DTO.AppointmentDTO;
import com.hungrycoders.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
        @Autowired
        private AppointmentService appointmentService;

        @PostMapping
        public AppointmentDTO bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
            return appointmentService.bookAppointment(appointmentDTO);
        }

        @GetMapping("{id}")
        public List<AppointmentDTO> getAppointmentsByPatient(@PathVariable String id) {
            return appointmentService.getById(id);
        }
}

package com.legal.lawyer_directory.controller;

import com.legal.lawyer_directory.model.Lawyer;
import com.legal.lawyer_directory.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lawyers")
public class LawyerRestController {

    @Autowired
    private LawyerService lawyerService;

    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return lawyerService.getAllLawyers();
    }

    @GetMapping("/specialization/{specialization}")
    public List<Lawyer> getLawyersBySpecialization(@PathVariable String specialization) {
        return lawyerService.getLawyersBySpecialization(specialization);
    }
}
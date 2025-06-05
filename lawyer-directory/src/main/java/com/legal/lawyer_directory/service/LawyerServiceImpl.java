// LawyerServiceImpl.java
package com.legal.lawyer_directory.service;

import com.legal.lawyer_directory.model.Lawyer;
import com.legal.lawyer_directory.model.Query;
import com.legal.lawyer_directory.repository.LawyerRepository;
import com.legal.lawyer_directory.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerServiceImpl extends LawyerService {

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private QueryRepository queryRepository;

    @Override
    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    @Override
    public List<Lawyer> getLawyersBySpecialization(String specialization) {
        return lawyerRepository.findByExpertiseContainingIgnoreCase(specialization);
    }

    @Override
    public void sendQuery(Query query) {
        queryRepository.save(query);
    }
}
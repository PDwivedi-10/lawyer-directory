package com.legal.lawyer_directory.controller;

import com.legal.lawyer_directory.model.Lawyer;
import com.legal.lawyer_directory.model.Query;
import com.legal.lawyer_directory.repository.LawyerRepository;
import com.legal.lawyer_directory.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    // List all lawyers
    @GetMapping("/")
    public String listLawyers(Model model) {
        model.addAttribute("lawyers", lawyerService.getAllLawyers());
        return "index";  // Thymeleaf view
    }

    // Show form to send query
    @GetMapping("/send-query/{lawyerId}")
    public String sendQueryForm(@PathVariable("lawyerId") Long lawyerId, Model model) {
        model.addAttribute("lawyerId", lawyerId);
        return "send-query";  // Thymeleaf view
    }

    // Submit query
    @PostMapping("/send-query")
    public String sendQuery(@RequestParam("lawyerId") Long lawyerId,
                            @RequestParam("userName") String userName,
                            @RequestParam("message") String message, Model model) {
        Lawyer lawyer = new Lawyer();
        lawyer.setId(lawyerId);

        Query query = new Query();
        query.setLawyer(lawyer);
        query.setMessage(message);
        query.setUserName(userName);

        lawyerService.sendQuery(query);

        model.addAttribute("message", "Query sent successfully!");
        return "send-query";
    }
}


package com.legal.lawyer_directory.controller;

import com.legal.lawyer_directory.model.Lawyer;
import com.legal.lawyer_directory.model.Query;
import com.legal.lawyer_directory.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queries")
public class QueryRestController {

    @Autowired
    private LawyerService lawyerService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuery(@RequestBody QueryRequestDto requestDto) {
        Lawyer lawyer = new Lawyer();
        lawyer.setId(requestDto.getLawyerId());

        Query query = new Query();
        query.setLawyer(lawyer);
        query.setUserName(requestDto.getUserName());
        query.setMessage(requestDto.getUserMessage());

        lawyerService.sendQuery(query);
        return ResponseEntity.ok("Query submitted successfully");
    }

    public static class QueryRequestDto {
        private Long lawyerId;
        private String userMessage;
        private String userName;

        // Getters and Setters
        public Long getLawyerId() {
            return lawyerId;
        }
        public void setLawyerId(Long lawyerId) {
            this.lawyerId = lawyerId;
        }

        public String getUserMessage() {
            return userMessage;
        }
        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}

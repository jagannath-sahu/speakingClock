package com.example.speakingClock.speakingClock.controller;

import java.time.LocalDateTime;

import com.example.speakingClock.speakingClock.service.SpeakingClockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakingClockController {
    
    @Autowired
    SpeakingClockService speakingClockService;
    
    @GetMapping("/getCurrentTime")
    ResponseEntity<String> getCurrentTimeInText() {
        return new ResponseEntity<>(speakingClockService.getCurrentTime(LocalDateTime.now()), HttpStatus.OK);
    }

}

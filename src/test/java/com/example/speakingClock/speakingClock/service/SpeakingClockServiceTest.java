package com.example.speakingClock.speakingClock.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
class SpeakingClockServiceTest {
    
    private SpeakingClockService speakingClockService;
    
    @Test
    void testGetCurrentTime() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 12:10:56 PM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's Midday twelve ten");
    }
    
    @Test
    void testMidNight() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 00:00:00 PM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's Midday");
    }
    
    @Test
    void testMidDayFifteen() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 00:15:00 AM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's Midnight twelve fifteen");
    }
    
    @Test
    void testMidday() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 00:00:00 AM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's Midnight");
    }
    
    @Test
    void testNormalTime() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 09:06:00 AM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's nine six");
    }
    
    @Test
    void testNormalTime1() {
        speakingClockService = new SpeakingClockService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
        String date = "Tuesday, Aug 16, 2016 09:25:00 AM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        String output = speakingClockService.getCurrentTime(localDateTime);
        assertEquals(output, "It's nine twenty five");
    }
}

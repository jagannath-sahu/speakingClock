package com.example.speakingClock.speakingClock.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.example.speakingClock.speakingClock.exception.IncorrectTimeInputFormatException;
import com.example.speakingClock.speakingClock.service.util.SpeakingClockUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.CURRENT_TIME_PREFIX;
import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.MIDNIGHT;
import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.MIDDAY;

@Service
public class SpeakingClockService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SpeakingClockService.class);
    
    public String getCurrentTime(LocalDateTime localDateTime) {

        String currTime = String.valueOf(localDateTime.getHour()).concat(":").concat(String.valueOf(localDateTime.getMinute()));
        
        // to check exception comment above line and uncomment this line
       // String currTime = String.valueOf(localDateTime.getHour()).concat(":").concat(String.valueOf(localDateTime.getMinute())).concat("anything");
        
        String finalOutput = null;
        
        if(localDateTime.getHour() == 0 && localDateTime.getMinute() == 0) {
            finalOutput = CURRENT_TIME_PREFIX.concat(MIDNIGHT);
        }
        else  if(localDateTime.getHour() == 12 && localDateTime.getMinute() == 0) {
            finalOutput = CURRENT_TIME_PREFIX.concat(MIDDAY);
        }
        else if(localDateTime.getHour() == 0 && localDateTime.getMinute() > 0) {
            currTime = MIDNIGHT.concat(":").concat(String.valueOf(localDateTime.getMinute()));
            try {
                finalOutput = Arrays.stream(currTime.split(":")).map(time -> SpeakingClockUtil.convertTimeToString(time)).collect(Collectors.joining(" "));
            }
            catch(NumberFormatException excep) {
                LOGGER.debug(excep.getMessage());
                throw new IncorrectTimeInputFormatException("Wrong Time Input Format, please pass correct time");
            }
        } 
        else if(localDateTime.getHour() == 12 && localDateTime.getMinute() > 0) {
            currTime = MIDDAY.concat(":").concat(String.valueOf(localDateTime.getMinute()));
            try {
                finalOutput = Arrays.stream(currTime.split(":")).map(time -> SpeakingClockUtil.convertTimeToString(time)).collect(Collectors.joining(" "));
            }
            catch(NumberFormatException excep) {
                LOGGER.debug(excep.getMessage());
                throw new IncorrectTimeInputFormatException("Wrong Time Input Format, please pass correct time");
            }
        } 
        else {
            try {
                finalOutput = CURRENT_TIME_PREFIX.concat(Arrays.stream(currTime.split(":")).map(time -> SpeakingClockUtil.convertTimeToString(time)).collect(Collectors.joining(" ")));
            }
            catch(NumberFormatException excep) {
                LOGGER.debug(excep.getMessage());
                throw new IncorrectTimeInputFormatException("Wrong Time Input Format, please pass correct time");
            }
        }
        return finalOutput;
    }

}

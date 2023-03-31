package com.example.speakingClock.speakingClock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IncorrectTimeInputFormatAdvice {
    
    @ResponseBody
    @ExceptionHandler(IncorrectTimeInputFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String incorrectTimeFomatHandler(IncorrectTimeInputFormatException ex) {
      return ex.getMessage();
    }

}

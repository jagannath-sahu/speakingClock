package com.example.speakingClock.speakingClock.service.util;

import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.CURRENT_TIME_PREFIX;
import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.MIDDAY;
import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.MIDNIGHT_TWELVE;
import static com.example.speakingClock.speakingClock.constants.SpeakingClockConstants.MIDDAY_TWELVE;

public class SpeakingClockUtil {
    
    public static String convertTimeToString(String time) throws NumberFormatException{
        if(time.equals("Midnight")) {
            return CURRENT_TIME_PREFIX.concat(MIDNIGHT_TWELVE);
        } 
        else if(time.equals(MIDDAY)) {
            return CURRENT_TIME_PREFIX.concat(MIDDAY_TWELVE);
        }
        int convertedTime = Integer.parseInt(time);
        
        if(convertedTime > 20) {
            int reminder = convertedTime % 10;
            int hour = convertedTime - reminder;
            return convertToText(String.valueOf(hour)).concat(" ").concat(convertToText(String.valueOf(reminder)));
        }
        return convertToText(time);
    }

    public static String convertToText(String inputTimeText) {
        int convertedTime = Integer.parseInt(inputTimeText);
        
        String resultTimeString = new String();
        
        switch(convertedTime) {
            case 1:
                resultTimeString = "one";
                break;
            case 2:
                resultTimeString = "two";
                break;
            case 3:
                resultTimeString = "three";
                break;
            case 4:
                resultTimeString = "four";
                break;
            case 5:
                resultTimeString = "five";
                break;
            case 6:
                resultTimeString = "six";
                break;
            case 7:
                resultTimeString = "seven";
                break;
            case 8:
                resultTimeString = "eight";
                break;
            case 9:
                resultTimeString = "nine";
                break;
            case 10:
                resultTimeString = "ten";
                break;
            case 11:
                resultTimeString = "eleven";
                break;
            case 12:
                resultTimeString = "twelve";
                break;
            case 13:
                resultTimeString = "thirteen";
                break;
            case 14:
                resultTimeString = "fourteen";
                break;
            case 15:
                resultTimeString = "fifteen";
                break;
            case 16:
                resultTimeString = "sixteen";
                break;
            case 17:
                resultTimeString = "seventeen";
                break;
            case 18:
                resultTimeString = "eighteen";
                break;
            case 19:
                resultTimeString = "ninteen";
                break;
            case 20:
                resultTimeString = "twenty";
                break;
            case 30:
                resultTimeString = "thirty";
                break;
            case 40:
                resultTimeString = "fourty";
                break;
            case 50:
                resultTimeString = "fifty";
                break;
            default:
                System.out.println("Wrong input time");
        }
        return resultTimeString;
    }

}

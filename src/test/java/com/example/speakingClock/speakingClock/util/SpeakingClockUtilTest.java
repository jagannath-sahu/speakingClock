package com.example.speakingClock.speakingClock.service.util;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
class SpeakingClockUtilTest {
    
    @Test
    void testConvertToText() {
        String result = SpeakingClockUtil.convertToText("1");
        assertEquals(result,"one");
        result = SpeakingClockUtil.convertToText("2");
        assertEquals(result,"two");
        result = SpeakingClockUtil.convertToText("3");
        assertEquals(result,"three");
        result = SpeakingClockUtil.convertToText("4");
        assertEquals(result,"four");
        result = SpeakingClockUtil.convertToText("7");
        assertEquals(result,"seven");
        result = SpeakingClockUtil.convertToText("8");
        assertEquals(result,"eight");
        result = SpeakingClockUtil.convertToText("11");
        assertEquals(result,"eleven");
        result = SpeakingClockUtil.convertToText("12");
        assertEquals(result,"twelve");
        result = SpeakingClockUtil.convertToText("13");
        assertEquals(result,"thirteen");
        result = SpeakingClockUtil.convertToText("14");
        assertEquals(result,"fourteen");
        result = SpeakingClockUtil.convertToText("16");
        assertEquals(result,"sixteen");
        result = SpeakingClockUtil.convertToText("17");
        assertEquals(result,"seventeen");
        result = SpeakingClockUtil.convertToText("18");
        assertEquals(result,"eighteen");
        result = SpeakingClockUtil.convertToText("19");
        assertEquals(result,"ninteen");
        result = SpeakingClockUtil.convertToText("30");
        assertEquals(result,"thirty");
        result = SpeakingClockUtil.convertToText("40");
        assertEquals(result,"fourty");
        result = SpeakingClockUtil.convertToText("50");
        assertEquals(result,"fifty");
        result = SpeakingClockUtil.convertToText("90");
        assertEquals(result,"");
    }
}

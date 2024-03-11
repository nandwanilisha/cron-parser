package com.parser.cronparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CronParserImplTest {

    private final int[] defaultMinutes = getDefaultValues(0, 60);
    private final int[] defaultHours = getDefaultValues(0, 24);
    private final int[] defaultDaysOfMonth = getDefaultValues(1, 31);
    private final int[] defaultMonth = getDefaultValues(1, 12);
    private final int[] defaultDaysOfWeek = getDefaultValues(1, 7);
    private final int[] mockResult = getDefaultValues(1, 7);


    @InjectMocks
    private CronParserImpl parserImpl;

    @Mock
    private CronParserHelper parserHelper;

    @Test
    public void testParserWhenMinutesGivenWithInterval() {
        when(parserHelper.parseValuesWithInterval("*/15",defaultMinutes)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("*/15 * * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesWithInterval("*/15", defaultMinutes);
    }

    @Test
    public void testParserWhenMinuteGivenWithRange() {
        when(parserHelper.parseValuesBetweenRange("3-5", defaultMinutes)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("3-5 * * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesBetweenRange("3-5", defaultMinutes);
    }

    @Test
    public void testParserWhenMinuteGivenWithDistinctValues() {
        when(parserHelper.parseDistinctCommaSeparatedValues("2,7", defaultMinutes)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("2,7 * * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseDistinctCommaSeparatedValues("2,7", defaultMinutes);
    }

    @Test
    public void testParserWhenHourGivenWithInterval() {
        when(parserHelper.parseValuesWithInterval("*/1",defaultHours)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* */1 * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesWithInterval("*/1", defaultHours);
    }

    @Test
    public void testParserWhenHourGivenWithRange() {
        when(parserHelper.parseValuesBetweenRange("2-4", defaultHours)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* 2-4 * * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesBetweenRange("2-4", defaultHours);
    }

    @Test
    public void testParserWhenHourGivenWithDistinctValues() {
        when(parserHelper.parseDistinctCommaSeparatedValues("21", defaultHours)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* 21 * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseDistinctCommaSeparatedValues("21", defaultHours);
    }

    @Test
    public void testParserWhenDaysOfMonthGivenWithInterval() {
        when(parserHelper.parseValuesWithInterval("*/11",defaultDaysOfMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * */11 * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesWithInterval("*/11", defaultDaysOfMonth);
    }

    @Test
    public void testParserWhenDaysOfMonthGivenWithRange() {
        when(parserHelper.parseValuesBetweenRange("13-27", defaultDaysOfMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * 13-27 * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesBetweenRange("13-27", defaultDaysOfMonth);
    }

    @Test
    public void testParserWhenDaysOfMonthGivenWithDistinctValues() {
        when(parserHelper.parseDistinctCommaSeparatedValues("1,30", defaultDaysOfMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * 1,30 * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseDistinctCommaSeparatedValues("1,30", defaultDaysOfMonth);
    }

    @Test
    public void testParserWhenMonthGivenWithInterval() {
        when(parserHelper.parseValuesWithInterval("*/8",defaultMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * * */8 * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesWithInterval("*/8", defaultMonth);
    }

    @Test
    public void testParserWhenMonthGivenWithRange() {
        when(parserHelper.parseValuesBetweenRange("2-7", defaultMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * * 2-7 * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesBetweenRange("2-7", defaultMonth);
    }

    @Test
    public void testParserWhenMonthGivenWithDistinctValues() {
        when(parserHelper.parseDistinctCommaSeparatedValues("2", defaultMonth)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * * 2 * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseDistinctCommaSeparatedValues("2", defaultMonth);
    }


    @Test
    public void testParserWhenDaysOfWeekGivenWithInterval() {
        when(parserHelper.parseValuesWithInterval("*/6",defaultDaysOfWeek)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * * * */6 /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesWithInterval("*/6", defaultDaysOfWeek);
    }

    @Test
    public void testParserWhenDaysOfWeekGivenWithRange() {
        when(parserHelper.parseValuesBetweenRange("1-7", defaultDaysOfWeek)).thenReturn(mockResult);
        String parsedString = parserImpl.parse("* * * * 1-7 /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verify(parserHelper, times(1)).parseValuesBetweenRange("1-7", defaultDaysOfWeek);
    }

    @Test
    public void testParserWhenInvalidValueIsPassedThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> parserImpl.parse("* * * * -4 /usr/bin/find"));
    }

    @Test
    public void testParserWhenAllIsGivenForAll() {
        String parsedString = parserImpl.parse("* * * * * /usr/bin/find");
        Assertions.assertNotNull(parsedString);
        verifyNoInteractions(parserHelper);
    }

    private int[] getDefaultValues(int lowerIndex, int length) {
        int[] defaultMinutes = new int[length];
        for (int i = 0; i < length; i++) {
            defaultMinutes[i] = i + lowerIndex;
        }
        return defaultMinutes;
    }
}
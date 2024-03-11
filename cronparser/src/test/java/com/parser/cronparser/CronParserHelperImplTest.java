package com.parser.cronparser;

import com.parser.validator.ParserInputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CronParserHelperImplTest {

    @InjectMocks
    private CronParserHelperImpl parserHelper;

    @Mock
    private ParserInputValidator inputValidator;

    private final int[] defaultValues = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"1,2,3 | 3", "3 | 1", "6,7,10,15 | 4"})
    public void testParseDistinctCommaSeparatedValues(String input, int outputLength) {
        int[] result = parserHelper.parseDistinctCommaSeparatedValues(input, defaultValues);
        assertNotNull(result);
        assertEquals(outputLength, result.length);
    }

    @Test
    public void testParseDistinctCommaSeparatedValuesWhenInvalidValueIsPassedThrowError() {
        when(inputValidator.isNotValid(17, defaultValues)).thenReturn(true);
        when(inputValidator.isNotValid(1, defaultValues)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> parserHelper.parseDistinctCommaSeparatedValues("1,17", defaultValues));
    }

    @ParameterizedTest
    @CsvSource(value = {"*/5,3", "*/3,5"})
    public void testParseValuesWithInterval(String input, int outputLength) {
        int[] result = parserHelper.parseValuesWithInterval(input, defaultValues);
        assertNotNull(result);
        assertEquals(outputLength, result.length);
    }

    @Test
    public void testParseValuesWithIntervalWhenInvalidValueIsPassedThrowError() {
        when(inputValidator.isNotValid(17, defaultValues)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> parserHelper.parseValuesWithInterval("*/17", defaultValues));
    }

    @ParameterizedTest
    @CsvSource(value = {"1-5,5", "2-8,7"})
    public void testParseValuesBetweenRange(String input, int outputLength) {
        int[] result = parserHelper.parseValuesBetweenRange(input, defaultValues);
        assertNotNull(result);
        assertEquals(outputLength, result.length);
    }

    @Test
    public void testParseValuesBetweenRangeWhenInvalidValueIsPassedThrowError() {
        when(inputValidator.isRangeNotValid(10,17, defaultValues)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> parserHelper.parseValuesBetweenRange("10-17", defaultValues));
    }
}
package com.parser.validator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ParserInputValidatorImplTest {

    @InjectMocks
    private ParserInputValidatorImpl inputValidator;

    private final int[] defaultValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    @ParameterizedTest
    @CsvSource({"1,false", "18,true"})
    public void testIsNotValidWhenGivenValueIsPassedThenReturnExpectedValue(int input, boolean expected) {
        boolean notValid = inputValidator.isNotValid(input, defaultValues);
        assertEquals(expected, notValid);
    }

    @ParameterizedTest
    @CsvSource({"1,5,false", "5,18,true"})
    public void testIsRangeNotValidWhenGivenValueIsPassedThenReturnExpectedValue(int startInput, int endInput, boolean expected) {
        boolean notValid = inputValidator.isRangeNotValid(startInput, endInput, defaultValues);
        assertEquals(expected, notValid);
    }
}
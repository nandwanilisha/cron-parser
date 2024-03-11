package com.parser.validator;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ParserInputValidatorImpl implements ParserInputValidator {

    public boolean isNotValid(int input, int[] defaultValues) {
        return Arrays.stream(defaultValues).noneMatch(value -> value == input);
    }

    public boolean isRangeNotValid(int start, int end, int[] defaultValues) {
        return start > end
                || Arrays.stream(defaultValues).noneMatch(value -> value == start)
                || Arrays.stream(defaultValues).noneMatch(value -> value == end);
    }
}

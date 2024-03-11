package com.parser.validator;

public interface ParserInputValidator {

    boolean isNotValid(int input, int[] defaultValues);

    boolean isRangeNotValid(int start, int end, int[] defaultValues);
}

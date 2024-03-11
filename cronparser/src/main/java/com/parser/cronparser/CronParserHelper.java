package com.parser.cronparser;

public interface CronParserHelper {

    int[] parseDistinctCommaSeparatedValues(String input, int[] defaultValues);
    int[] parseValuesWithInterval(String input, int[] defaultValues);
    int[] parseValuesBetweenRange(String input, int[] defaultValues);
}

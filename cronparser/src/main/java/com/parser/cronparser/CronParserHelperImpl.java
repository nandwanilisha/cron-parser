package com.parser.cronparser;

import com.parser.validator.ParserInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.parser.constants.ParserHelperConstants.*;

@Service
public class CronParserHelperImpl implements CronParserHelper {

    @Autowired
    private ParserInputValidator inputValidator;

    public int[] parseDistinctCommaSeparatedValues(String input, int[] defaultValues) {
        int[] inputs = Arrays.stream(input.split(commaDelimiter)).mapToInt(Integer::parseInt).toArray();

        for(int val : inputs) {
            if(inputValidator.isNotValid(val, defaultValues)) {
                throw new IllegalArgumentException(invalidValue + val);
            }
        }
        return inputs;
    }

    public int[] parseValuesWithInterval(String input, int[] defaultValues) {
        int interval = Integer.parseInt(input.substring(2));

        if(inputValidator.isNotValid(interval, defaultValues)) {
            throw new IllegalArgumentException( invalidInterval+ interval);
        }

        int[] result = new int[Math.ceilDiv(defaultValues.length, interval)];
        for (int i = 0, j = 0; j < defaultValues.length; i++, j = j + interval) {
            result[i] = defaultValues[j];
        }
        return result;
    }

    public int[] parseValuesBetweenRange(String input, int[] defaultValues) {
        String[] rangeLimits = input.split(hyphenDelimiter);
        int startValue = Integer.parseInt(rangeLimits[0]);
        int endValue = Integer.parseInt(rangeLimits[1]);

        if(inputValidator.isRangeNotValid(startValue, endValue, defaultValues)) {
            throw new IllegalArgumentException(invalidRange + startValue + commaDelimiter + endValue);
        }

        if (Arrays.stream(defaultValues).anyMatch(v -> v == startValue) && Arrays.stream(defaultValues).anyMatch(v -> v == endValue)) {
            return getRange(startValue, endValue);
        }
        return defaultValues;
    }

    private int[] getRange(int startValue, int endValue) {
        int[] range = new int[endValue - startValue + 1];
        for (int i = startValue; i <= endValue; i++) {
            range[i - startValue] = i;
        }
        return range;
    }
}

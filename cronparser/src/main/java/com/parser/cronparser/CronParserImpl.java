package com.parser.cronparser;

import com.parser.model.CommandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.parser.constants.ParserConstants.*;

@Service
public class CronParserImpl implements CronParser{
    private final int[] defaultMinutes = getDefaultValues(minutesStartValue, minutesTotalLength);
    private final int[] defaultHours = getDefaultValues(hoursStartValue, hoursTotalLength);
    private final int[] defaultDaysOfMonth = getDefaultValues(daysOfMonthStartValue, daysOfMonthTotalLength);
    private final int[] defaultMonth = getDefaultValues(monthStartValue, monthTotalLength);
    private final int[] defaultDaysOfWeek = getDefaultValues(daysOfWeekStartValue, daysOfWeekTotalLength);

    @Autowired
    private CronParserHelper parserHelper;
    public String parse(String command) {

        String[] commandInputs = command.split(commandDelimiter);

        CommandModel commandModel = new CommandModel();
        commandModel.getMinute().setParsedValue(getArrayInString(analyzeCommand(commandInputs[0], defaultMinutes)));
        commandModel.getHour().setParsedValue(getArrayInString(analyzeCommand(commandInputs[1], defaultHours)));
        commandModel.getDayOfMonth().setParsedValue(getArrayInString(analyzeCommand(commandInputs[2], defaultDaysOfMonth)));
        commandModel.getMonth().setParsedValue(getArrayInString(analyzeCommand(commandInputs[3], defaultMonth)));
        commandModel.getDayOfWeek().setParsedValue(getArrayInString(analyzeCommand(commandInputs[4], defaultDaysOfWeek)));
        commandModel.getCommand().setParsedValue(commandInputs[5]);

        return commandModel.toString();
    }

    private String getArrayInString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j : array) {
            stringBuilder.append(j).append(responseDelimiter);
        }
        return stringBuilder.toString().trim();
    }

    private int[] getDefaultValues(int lowerIndex, int length) {
        int[] defaultMinutes = new int[length];
        for (int i = 0; i < length; i++) {
            defaultMinutes[i] = i + lowerIndex;
        }
        return defaultMinutes;
    }

    private int[] analyzeCommand(String value, int[] defaultValues) {

        return switch (value) {
            case String v when Pattern.compile(intervalParserRegex).matcher(v).matches() ->
                    parserHelper.parseValuesWithInterval(v, defaultValues);
            case String v when Pattern.compile(allMatchRegex).matcher(v).matches() -> defaultValues;
            case String v when Pattern.compile(rangeParserRegex).matcher(v).matches() ->
                    parserHelper.parseValuesBetweenRange(value, defaultValues);
            case String v when Pattern.compile(commaSeparatedParserRegex).matcher(v).matches() ->
                    parserHelper.parseDistinctCommaSeparatedValues(v, defaultValues);
            default -> throw new IllegalArgumentException(unexpectedValue + value);
        };
    }
}

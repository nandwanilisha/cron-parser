package com.parser.model;

import com.parser.constants.ParserConstants;
import lombok.Getter;

@Getter
public class CommandModel {
    private final KeyValuePair minute;
    private final KeyValuePair hour;
    private final KeyValuePair dayOfMonth;
    private final KeyValuePair month;
    private final KeyValuePair dayOfWeek;
    private final KeyValuePair command;

    public CommandModel() {
        minute = new KeyValuePair(ParserConstants.minute);
        hour = new KeyValuePair(ParserConstants.hour);
        dayOfMonth = new KeyValuePair(ParserConstants.dayOfMonth);
        month = new KeyValuePair(ParserConstants.month);
        dayOfWeek = new KeyValuePair(ParserConstants.dayOfWeek);
        command = new KeyValuePair(ParserConstants.command);
    }

    @Override
    public String toString() {
        int keyLength = -14;
        return String.format("%" + keyLength + "s", minute.getKey()) + minute.getParsedValue() + "\n" +
                String.format("%" + keyLength + "s", hour.getKey()) + hour.getParsedValue() + "\n" +
                String.format("%" + keyLength + "s", dayOfMonth.getKey()) + dayOfMonth.getParsedValue() + "\n" +
                String.format("%" + keyLength + "s", month.getKey()) + month.getParsedValue() + "\n" +
                String.format("%" + keyLength + "s", dayOfWeek.getKey()) + dayOfWeek.getParsedValue() + "\n" +
                String.format("%" + keyLength + "s", command.getKey()) + command.getParsedValue() + "\n";
    }
}

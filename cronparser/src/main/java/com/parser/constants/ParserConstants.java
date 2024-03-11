package com.parser.constants;

public class ParserConstants {

    public final static int minutesStartValue = 0;
    public final static int minutesTotalLength = 60;
    public final static int hoursStartValue = 0;
    public final static int hoursTotalLength = 24;
    public final static int daysOfMonthStartValue = 1;
    public final static int daysOfMonthTotalLength= 31;
    public final static int monthStartValue = 1;
    public final static int monthTotalLength = 12;
    public final static int daysOfWeekStartValue = 1;
    public final static int daysOfWeekTotalLength = 7;
    public final static String commandDelimiter = " ";
    public final static String responseDelimiter = " ";
    public final static String intervalParserRegex = "\\*\\/\\d+";
    public final static String allMatchRegex = "\\*";
    public final static String commaSeparatedParserRegex = "\\d+(,\\d+)*";
    public final static String rangeParserRegex = "\\d+-\\d+";
    public final static String unexpectedValue = "Unexpected value: ";
    public final static String minute = "minute";
    public final static String dayOfWeek = "day of week";
    public final static String hour = "hour";
    public final static String month = "month";
    public final static String dayOfMonth = "day of month";
    public final static String command = "command";
}

package com.parser.commands.commands;

import com.parser.cronparser.CronParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ParseCommand {

    @Autowired
    private CronParser cronParser;

    @ShellMethod(key = "cron-parser")
    public String parse(@ShellOption String command) {
        return cronParser.parse(command);
    }
}

package org.rivanshu.cronparser.models;

import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Getter
public class CronExpression {

    private final Set<Integer> minutes;
    private final Set<Integer> hours;
    private final Set<Integer> dayOfMonth;
    private final Set<Integer> month;
    private final Set<Integer> dayOfWeek;
    private final String command;

    public CronExpression(Set<Integer> minutes, Set<Integer> hours, Set<Integer> dayOfMonth, Set<Integer> month, Set<Integer> dayOfWeek, String command) {
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.command = command;
    }

    public String toString() {
        return format("%-14s%s\n", "minute", toString(minutes)) +
                format("%-14s%s\n", "hour", toString(hours)) +
                format("%-14s%s\n", "day of month", toString(dayOfMonth)) +
                format("%-14s%s\n", "month", toString(month)) +
                format("%-14s%s\n", "day of week", toString(dayOfWeek)) +
                format("%-14s%s\n", "command", command);
    }

    private String toString(Set<Integer> values){
        return values.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

}

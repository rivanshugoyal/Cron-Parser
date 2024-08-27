package org.rivanshu.cronparser.parser;

import lombok.AllArgsConstructor;
import org.rivanshu.cronparser.exception.CronException;
import org.rivanshu.cronparser.models.CronFieldType;

import java.util.*;
import java.util.stream.IntStream;

import static org.rivanshu.cronparser.exception.CronErrorCode.INVALID_CRON_VALUE;

@AllArgsConstructor
public abstract class CronFieldParser {

    private static final String COMMA = ",";
    private static final String SLASH = "/";
    private static final String HYPHEN = "-";
    private static final String WILDCARD = "*";
    private final CronFieldType cronFieldType;

    public Set<Integer> parse(String input) throws CronException {

        if (input.strip().contains(SLASH)) {
            return stepParser(input);
        } else if (input.strip().contains(COMMA)) {
            return commaParser(input);
        } else if (input.strip().contains(HYPHEN)) {
            return rangeParser(input);
        } else if (input.strip().equals(WILDCARD)) {
            return wildcardParser();
        }

        return Set.of(validateAndGet(input));
    }

    private Set<Integer> commaParser(String input) throws CronException {
        Set<Integer> values = new TreeSet<>();
        String[] inputs = input.split(COMMA);
        for (String inp : inputs) {
            values.addAll(parse(inp));
        }
        return values;
    }

    private Set<Integer> stepParser(String input) throws CronException {
        Set<Integer> values = new TreeSet<>();
        int index = input.indexOf("/");
        List<Integer> range = new ArrayList<>(parse(input.substring(0, index)));
        if(range.size() == 1){
            IntStream.rangeClosed(range.get(0) + 1, cronFieldType.getMax())
                    .forEach(range::add);
        }
        range.sort(Integer::compareTo);
        int step = validateAndGet(input.substring(index + 1));
        for (int start = range.get(0); start <= range.get(range.size() - 1); start += step) {
            if (range.contains(start)) {
                values.add(start);
            }
        }
        return values;
    }

    private Set<Integer> rangeParser(String input) throws CronException {
        Set<Integer> values = new TreeSet<>();

        int index = input.indexOf("-");

        int start = validateAndGet(input.substring(0, index));
        int end = validateAndGet(input.substring(index + 1, input.length()));

        for (int i = start; i <= end; i++) {
            values.add(i);
        }
        return values;
    }

    private Set<Integer> wildcardParser() {
        Set<Integer> values = new TreeSet<>();
        for (int i = cronFieldType.getMin(); i <= cronFieldType.getMax(); i++) {
            values.add(i);
        }
        return values;
    }

    private Integer validateAndGet(String value) throws CronException {
        try {
            int integerValue = Integer.parseInt(value);
            if (integerValue >= cronFieldType.getMin() && integerValue <= cronFieldType.getMax()) {
                return integerValue;
            }
            throw CronException.raise(INVALID_CRON_VALUE, Map.of("cronFieldType", cronFieldType.name(), "cronFieldValue", value));
        } catch (NumberFormatException e) {
            throw CronException.raise(INVALID_CRON_VALUE, Map.of("cronFieldType", cronFieldType.name(), "cronFieldValue", value));
        }
    }
}

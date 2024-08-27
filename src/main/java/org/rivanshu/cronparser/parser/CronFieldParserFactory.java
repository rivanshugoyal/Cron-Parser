package org.rivanshu.cronparser.parser;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CronFieldParserFactory {
    Map<CronFieldType, CronFieldParser> parsers;

    public CronFieldParserFactory() {
        parsers = new HashMap<>();
        parsers.put(CronFieldType.MINUTES, new MinutesParser());
        parsers.put(CronFieldType.HOURS, new HoursParser());
        parsers.put(CronFieldType.DAY_OF_MONTH, new DayOfMonthParser());
        parsers.put(CronFieldType.MONTH, new MonthParser());
        parsers.put(CronFieldType.DAY_OF_WEEK, new DayOfWeekParser());
    }

    public CronFieldParser getParser(CronFieldType type) {
        return parsers.get(type);
    }
}

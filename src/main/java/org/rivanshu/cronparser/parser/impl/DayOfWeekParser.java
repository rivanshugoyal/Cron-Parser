package org.rivanshu.cronparser.parser.impl;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParser;

public class DayOfWeekParser extends CronFieldParser {

    public DayOfWeekParser() {
        super(CronFieldType.DAY_OF_WEEK);
    }
}

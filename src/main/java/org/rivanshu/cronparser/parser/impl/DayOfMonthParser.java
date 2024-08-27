package org.rivanshu.cronparser.parser.impl;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParser;

public class DayOfMonthParser extends CronFieldParser {

    public DayOfMonthParser() {
        super(CronFieldType.DAY_OF_MONTH);
    }
}

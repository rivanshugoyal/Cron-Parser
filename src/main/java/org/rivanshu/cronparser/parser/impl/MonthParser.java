package org.rivanshu.cronparser.parser.impl;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParser;

public class MonthParser extends CronFieldParser {

    public MonthParser() {
        super(CronFieldType.MONTH);
    }
}

package org.rivanshu.cronparser.parser.impl;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParser;

public class HoursParser extends CronFieldParser {

    public HoursParser() {
        super(CronFieldType.HOURS);
    }
}

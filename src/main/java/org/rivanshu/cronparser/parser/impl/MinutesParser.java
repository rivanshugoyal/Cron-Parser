package org.rivanshu.cronparser.parser.impl;

import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParser;

public class MinutesParser extends CronFieldParser {

    public MinutesParser() {
        super(CronFieldType.MINUTES);
    }
}

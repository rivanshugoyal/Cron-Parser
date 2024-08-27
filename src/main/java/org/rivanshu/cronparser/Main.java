package org.rivanshu.cronparser;

import org.rivanshu.cronparser.exception.CronErrorCode;
import org.rivanshu.cronparser.exception.CronException;
import org.rivanshu.cronparser.models.CronExpression;
import org.rivanshu.cronparser.models.CronFieldType;
import org.rivanshu.cronparser.parser.CronFieldParserFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final CronFieldParserFactory cronFieldParserFactory = new CronFieldParserFactory();


    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw CronException.raise(CronErrorCode.INVALID_CRON_EXPRESSION,
                        Map.of("expression", ""));
            }
            String[] expressionFields = args[0].split(" ");

            if(expressionFields.length != 6) {
                throw CronException.raise(CronErrorCode.INVALID_CRON_EXPRESSION,
                        Map.of("expression", args[0]));
            }

            Set<Integer> minutes = getValues(expressionFields[0], CronFieldType.MINUTES);
            Set<Integer> hours = getValues(expressionFields[1], CronFieldType.HOURS);
            Set<Integer> dayOfMonth = getValues(expressionFields[2], CronFieldType.DAY_OF_MONTH);
            Set<Integer> month = getValues(expressionFields[3], CronFieldType.MONTH);
            Set<Integer> dayOfWeek = getValues(expressionFields[4], CronFieldType.DAY_OF_WEEK);
            CronExpression expr = new CronExpression(minutes, hours, dayOfMonth, month, dayOfWeek, expressionFields[5]);
            System.out.println(expr);

        } catch (CronException cronException) {
            System.err.println(cronException.getMessage());
        }
    }

    private static Set<Integer> getValues(String expression, CronFieldType cronFieldType) throws CronException {
        return cronFieldParserFactory.getParser(cronFieldType).parse(expression);
    }
}
package org.rivanshu.cronparser;

import org.rivanshu.cronparser.exception.CronErrorCode;
import org.rivanshu.cronparser.exception.CronException;
import org.rivanshu.cronparser.models.CronExpression;

import java.util.Map;

public class Main {

    private static final CronExpressionBuilder cronExpressionBuilder = new CronExpressionBuilder();

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw CronException.raise(CronErrorCode.INVALID_CRON_EXPRESSION,
                        Map.of("expression", ""));
            }
            CronExpression expr = cronExpressionBuilder.build(args[0]);
            System.out.println(expr);
        } catch (CronException cronException) {
            System.err.println(cronException.getMessage());
        }
    }


}
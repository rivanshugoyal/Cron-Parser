package org.rivanshu.cronparser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rivanshu.cronparser.exception.CronErrorCode;
import org.rivanshu.cronparser.exception.CronException;
import org.rivanshu.cronparser.models.CronExpression;

import static org.junit.Assert.fail;

public class CronExpressionBuilderTest {

    private CronExpressionBuilder cronExpressionBuilder;

    @Before
    public void setUp() {
        cronExpressionBuilder = new CronExpressionBuilder(  );
    }

    @Test
    public void rangeTest_validRange() throws CronException {
        String expression = "50-59 * * * * /usr/cmd";
        CronExpression cronExpression = cronExpressionBuilder.build(expression);
        Assert.assertEquals(10, cronExpression.getMinutes().size());
    }

    @Test
    public void rangeTest_inValidRange() throws CronException {
        String expression = "50-60 * * * * /usr/cmd";
        try {
            cronExpressionBuilder.build(expression);
            fail();
        } catch (CronException e) {
            Assert.assertEquals(CronErrorCode.INVALID_CRON_VALUE, e.getErrorCode());
        }
    }

    @Test
    public void stepTest_validStart() throws CronException {
        String expression = "50-59 */5 * * * /usr/cmd";
        CronExpression cronExpression = cronExpressionBuilder.build(expression);
        Assert.assertEquals(5, cronExpression.getHours().size());
    }

    @Test
    public void stepTest_validComplexStart() throws CronException {
        String expression = "50-59 13-14,16-23/5 * * * /usr/cmd";
        CronExpression cronExpression = cronExpressionBuilder.build(expression);
        Assert.assertEquals(3, cronExpression.getHours().size());
    }

    @Test
    public void stepTest_inValidComplexStart() throws CronException {
        String expression = "50-59 24/5 * * * /usr/cmd";
        try {
            cronExpressionBuilder.build(expression);
            fail();
        } catch (CronException e) {
            Assert.assertEquals(CronErrorCode.INVALID_CRON_VALUE, e.getErrorCode());
        }
    }

    @Test
    public void commaTest_validStart() throws CronException {
        String expression = "50-59 */5 2,5,7,12-15,9 * * /usr/cmd";
        CronExpression cronExpression = cronExpressionBuilder.build(expression);
        Assert.assertEquals(8, cronExpression.getDayOfMonth().size());
    }

    @Test
    public void commaTest_inValidValue() throws CronException {
        String expression = "50-59 */5 2,5,7,12-15,9,33 * * /usr/cmd";
        try {
            cronExpressionBuilder.build(expression);
            fail();
        } catch (CronException e) {
            Assert.assertEquals(CronErrorCode.INVALID_CRON_VALUE, e.getErrorCode());
        }
    }

    @Test
    public void wildcardTest_validStart() throws CronException {
        String expression = "50-59 */5 2,5,7,12-15,9 *,9,12 * /usr/cmd";
        CronExpression cronExpression = cronExpressionBuilder.build(expression);
        Assert.assertEquals(8, cronExpression.getDayOfMonth().size());
    }
}
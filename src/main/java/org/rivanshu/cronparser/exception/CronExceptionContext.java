package org.rivanshu.cronparser.exception;

import java.util.HashMap;
import java.util.Map;

public class CronExceptionContext extends HashMap<String, Object> {

    public CronExceptionContext(Map<String, Object> context) {
        putAll(context);
    }
}

package org.rivanshu.cronparser.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.text.StringSubstitutor;
import org.rivanshu.cronparser.exception.CronErrorCode;

import java.util.Map;

@UtilityClass
public class ErrorUtils {

    public static String getMessage(CronErrorCode errorCode, Map<String, Object> context) {
        return String.format("Error [%s]: %s", errorCode.getCode(),
                new StringSubstitutor(context)
                        .replace(errorCode.getMessage()));
    }
}

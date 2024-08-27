package org.rivanshu.cronparser.exception;

import lombok.Getter;
import org.rivanshu.cronparser.utils.ErrorUtils;

import java.util.Map;

@Getter
public class CronException extends Exception {

    private final CronErrorCode errorCode;
    private final CronExceptionContext context;

    private CronException(final CronErrorCode errorCode,
                          final Map<String, Object> context) {
        super(ErrorUtils.getMessage(errorCode, context));
        this.errorCode = errorCode;
        this.context = new CronExceptionContext(context);
    }

    public static CronException raise(final CronErrorCode errorCode,
                                      final Map<String, Object> context) {
        return new CronException(errorCode, context);
    }

}

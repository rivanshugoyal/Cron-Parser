package org.rivanshu.cronparser.exception;

import lombok.Getter;

@Getter
public enum CronErrorCode {

    INVALID_CRON_EXPRESSION("CE001", "Invalid cron expression! Expected [minute] [hour] [day of month] [month] [day of week] [command] but got : ${expression}"),
    INVALID_CRON_VALUE("CE002", "Cron value out of range for type: ${cronFieldType}, incorrectValue: ${cronFieldValue}");

    private final String code;
    private final String message;

    CronErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}

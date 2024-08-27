package org.rivanshu.cronparser.models;

import lombok.Getter;


@Getter
public enum CronFieldType {
    MINUTES(0, 59),
    HOURS(0, 23),
    DAY_OF_MONTH(1, 31),
    MONTH(1, 12),
    DAY_OF_WEEK(1, 7);

    private final int min;
    private final int max;

    CronFieldType(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

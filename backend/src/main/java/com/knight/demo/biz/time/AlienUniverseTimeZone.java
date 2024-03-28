package com.knight.demo.biz.time;

import java.util.Arrays;

public final class AlienUniverseTimeZone extends UniverseTimeZone {

    public static final int DAYS_OF_YEAR = Arrays.stream(MONTH.values()).map(MONTH::getValue).reduce(0, Integer::sum);
    public static final long SECONDS_OF_SECOND = 1;
    public static final long SECONDS_OF_MINUTE = SECONDS_OF_SECOND * 90;
    public static final long SECONDS_OF_HOUR = SECONDS_OF_MINUTE * 90;
    public static final long SECONDS_OF_DAY = SECONDS_OF_HOUR * 36;
    public static final long SECONDS_OF_YEAR = SECONDS_OF_DAY * DAYS_OF_YEAR;

    public static AlienUniverseTimeZone getInstance() {
        return new AlienUniverseTimeZone();
    }

    private AlienUniverseTimeZone() {
        super(0, 2);
    }

}

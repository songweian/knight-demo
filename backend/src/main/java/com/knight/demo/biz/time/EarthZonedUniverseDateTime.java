package com.knight.demo.biz.time;

import java.time.Instant;
import java.time.OffsetDateTime;

import static com.knight.demo.biz.time.UniverseTimeZone.EARTH_UTC_OFFSET;

public final class EarthZonedUniverseDateTime extends ZonedUniverseDateTime {

    public EarthZonedUniverseDateTime(UniverseTimeZone timeZone, long time) {
        super(timeZone, time);
    }

    @Override
    protected void compute() {
        Instant instant = Instant.ofEpochSecond(this.time);
        OffsetDateTime offsetDateTime = instant.atOffset(timeZone.toEarthTimeOffset());
        this.year = offsetDateTime.getYear();
        this.month = offsetDateTime.getMonthValue();
        this.day = offsetDateTime.getDayOfMonth();
        this.hour = offsetDateTime.getHour();
        this.minute = offsetDateTime.getMinute();
        this.second = offsetDateTime.getSecond();
    }

    public static EarthZonedUniverseDateTime of(int year, int month, int day, int hour, int minute, int second) {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(year, month, day, hour, minute, second, 0, EARTH_UTC_OFFSET.toEarthTimeOffset());
        long epochSeconds = offsetDateTime.toInstant().getEpochSecond();
        return new EarthZonedUniverseDateTime(EARTH_UTC_OFFSET, epochSeconds);
    }

}

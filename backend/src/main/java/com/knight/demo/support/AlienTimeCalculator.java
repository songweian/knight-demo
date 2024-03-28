package com.knight.demo.support;

import com.knight.demo.biz.time.AlienUniverseTimeZone;
import com.knight.demo.biz.time.AlienZonedUniverseDateTime;
import com.knight.demo.biz.time.MONTH;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.knight.demo.biz.time.AlienUniverseTimeZone.*;

public class AlienTimeCalculator {

    public static void main(String[] args) {
        time();
    }

    public static long time() {

        OffsetDateTime offsetDateTime = OffsetDateTime.of(1970, 1, 1, 12, 0, 0, 0, ZoneOffset.UTC);
        System.out.println(offsetDateTime);
        long earth_utc_diff = offsetDateTime.toInstant().getEpochSecond();

        long alien_utc_diff = earth_utc_diff * 2;

        System.out.println("diff = " + alien_utc_diff);
        int year = 2804;
        int month = 18;
        int day = 31;
        int hour = 2;
        int minute = 2;
        int sec = 88;
        long seconds = (year + 1) * SECONDS_OF_YEAR;
        seconds -= MONTH.MONTH_18.getValue() * SECONDS_OF_DAY;
        seconds += (day - 1) * SECONDS_OF_DAY;
        seconds += hour * SECONDS_OF_HOUR;
        seconds += minute * SECONDS_OF_MINUTE;
        seconds += sec * SECONDS_OF_SECOND;
        System.out.println("earth_utc_diff = " + earth_utc_diff);
        System.out.println("alien_utc_diff = " + alien_utc_diff);
//        AlienZonedUniverseDateTime.of(AlienUniverseTimeZone.getAlienTimeZone(), seconds / 2 - earth_utc_diff).print();
        AlienZonedUniverseDateTime.of(AlienUniverseTimeZone.getAlienTimeZone(), earth_utc_diff).print();
//
        return 0;
    }

}

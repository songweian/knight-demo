package com.knight.demo.biz.time;

import static com.knight.demo.biz.time.UniverseTimeZone.ALIEN_OFFSET;

public class TimeApp {
    public static void main(String[] args) {
        EarthZonedUniverseDateTime earthZonedUniverseDateTime =
                EarthZonedUniverseDateTime.of(1970, 1, 1, 12, 0, 0);
        earthZonedUniverseDateTime.print();
        UniverseInstant instant = earthZonedUniverseDateTime.toInstant();
        instant.toLocalUniverseDateTime(ALIEN_OFFSET).print();
    }
}

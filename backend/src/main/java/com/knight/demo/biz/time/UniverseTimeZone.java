package com.knight.demo.biz.time;

import java.time.ZoneOffset;

public sealed class UniverseTimeZone permits AlienUniverseTimeZone, EarthUniverseTimeZone {

    protected long offset;

    protected double speed;

    public static final UniverseTimeZone EARTH_UTC_OFFSET = new EarthUniverseTimeZone(0);
    public static final UniverseTimeZone ALIEN_OFFSET = AlienUniverseTimeZone.getInstance();

    public UniverseTimeZone(long offset, double speed) {
        this.offset = offset;
        this.speed = speed;
    }

    public long ofLocalTime(long time) {
        long localTime = (long) (time * speed);
        return localTime;
    }

    ZoneOffset toEarthTimeOffset() {
        return ZoneOffset.ofTotalSeconds((int) offset);
    }
}

package com.knight.demo.biz.time;

import static com.knight.demo.biz.time.UniverseTimeZone.EARTH_UTC_OFFSET;

public class UniverseDuration {
    private final UniverseTimeZone timeZone;

    private final long duration;

    public UniverseDuration(UniverseTimeZone timeZone, long duration) {
        this.timeZone = timeZone;
        this.duration = duration;
    }


    public static UniverseDuration of(UniverseInstant one, UniverseInstant two) {
        return new UniverseDuration(EARTH_UTC_OFFSET, two.getTime() - one.getTime());
    }

    public long toUniverseUTCSeconds() {
        return duration;
    }
}

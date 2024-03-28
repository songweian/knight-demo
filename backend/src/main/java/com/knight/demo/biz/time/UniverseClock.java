package com.knight.demo.biz.time;

public class UniverseClock {

    protected UniverseTimeZone timeZone;

    public UniverseClock(UniverseTimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public UniverseClock() {
        this.timeZone = new UniverseTimeZone(0, 0);
    }

    public static UniverseInstant currentInstant() {
        return new UniverseInstant(System.currentTimeMillis());
    }

    public long now() {
        return System.currentTimeMillis();
    }

}

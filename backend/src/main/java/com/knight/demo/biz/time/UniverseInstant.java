package com.knight.demo.biz.time;

public class UniverseInstant implements Comparable<UniverseInstant> {

    private long time;

    protected UniverseInstant(long time) {
        this.time = time;
    }

    public static UniverseInstant now() {
        return UniverseClock.currentInstant();
    }

    public static UniverseInstant of(long time) {
        return new UniverseInstant(time);
    }

    public ZonedUniverseDateTime toLocalUniverseDateTime(UniverseTimeZone timeZone) {
        return ZonedUniverseDateTime.of(timeZone, time);
    }

    @Override
    public int compareTo(UniverseInstant o) {
        return Long.compare(o.time, time);
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return this.time + " seconds";
    }
}

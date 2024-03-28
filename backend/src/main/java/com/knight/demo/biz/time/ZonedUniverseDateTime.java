package com.knight.demo.biz.time;

public sealed class ZonedUniverseDateTime permits AlienZonedUniverseDateTime, EarthZonedUniverseDateTime {

    protected UniverseTimeZone timeZone;
    protected long time;

    protected int year;
    protected int month;
    protected int day;
    protected int hour;
    protected int minute;
    protected int second;

    protected ZonedUniverseDateTime(UniverseTimeZone timeZone, long time) {
        this.timeZone = timeZone;
        this.time = time;
        this.compute();
    }

    public static ZonedUniverseDateTime of(UniverseTimeZone timeZone, long time) {
        switch (timeZone) {
            case AlienUniverseTimeZone alienTimeZone -> {
                return new AlienZonedUniverseDateTime(alienTimeZone, time);
            }
            case EarthUniverseTimeZone earthTimeZone -> {
                return new EarthZonedUniverseDateTime(earthTimeZone, time);
            }
            default -> throw new IllegalStateException("Unexpected value: " + timeZone);
        }
    }

    public UniverseInstant toInstant() {
        return UniverseInstant.of(this.time);
    }

    protected void compute() {
        throw new UnsupportedOperationException("This method must be implemented by the subclass");
    }

    public int getYear() {
        return this.year;
    }


    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void print() {
        String format = String.format("%d-%d-%d %d:%d:%d", this.year, this.month, this.day, this.hour, this.minute, this.second);
        System.out.println(format);
    }
}

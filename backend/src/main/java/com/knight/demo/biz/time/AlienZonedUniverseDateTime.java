package com.knight.demo.biz.time;

import com.knight.demo.support.SafeNumber;

import static com.knight.demo.biz.time.AlienUniverseTimeZone.*;

public final class AlienZonedUniverseDateTime extends ZonedUniverseDateTime {

    private static final long START_YEAR = 2804;

    private static final long START_MONTH = 18;
    private static final long START_DAY = 30;
    private static final long START_HOUR = 27;
    private static final long START_MINUTE = 32;
    private static final long START_SECOND = 88;

    private static final long diffSeconds;

    static {
        long secs = SECONDS_OF_YEAR - MONTH.MONTH_18.getValue() * SECONDS_OF_DAY;
        secs += (START_DAY - 1) * SECONDS_OF_DAY;
        secs += START_HOUR * SECONDS_OF_HOUR;
        secs += START_MINUTE * SECONDS_OF_MINUTE;
        secs += START_SECOND * SECONDS_OF_SECOND;
        diffSeconds = secs;
    }

    public AlienZonedUniverseDateTime(UniverseTimeZone timeZone, long time) {
        super(timeZone, time);
    }

    @Override
    protected void compute() {
        cal(START_YEAR, diffSeconds);
    }

    public void cal(long startYear, long diffSeconds) {
        long localTime = timeZone.ofLocalTime(time) + diffSeconds;

        int year = SafeNumber.long2int(localTime / SECONDS_OF_YEAR);

        long remainSeconds = localTime % SECONDS_OF_YEAR;

        long dayOfYear = remainSeconds / SECONDS_OF_DAY;
        remainSeconds = remainSeconds % SECONDS_OF_DAY;
        if (remainSeconds > 0) {
            dayOfYear++;
        }

        MonthDayInfo monthDayInfo = MONTH.of(SafeNumber.long2int(dayOfYear));
        int month = monthDayInfo.getMonthOfYear();
        int day = monthDayInfo.getDayOfMonth();
        int hour = SafeNumber.long2int(remainSeconds / SECONDS_OF_HOUR);
        remainSeconds = remainSeconds % SECONDS_OF_HOUR;
        int minute = SafeNumber.long2int(remainSeconds / SECONDS_OF_MINUTE);
        remainSeconds = remainSeconds % SECONDS_OF_MINUTE;
        int second = SafeNumber.long2int(remainSeconds / SECONDS_OF_SECOND);

        this.year = SafeNumber.long2int(year + startYear);
        this.month = SafeNumber.long2int(month);
        this.day = SafeNumber.long2int(day);
        this.hour = SafeNumber.long2int(hour);
        this.minute = SafeNumber.long2int(minute);
        this.second = SafeNumber.long2int(second);
    }

}

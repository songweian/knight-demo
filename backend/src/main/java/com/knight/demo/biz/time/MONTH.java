package com.knight.demo.biz.time;


import java.util.Arrays;
import java.util.stream.Stream;

import static com.knight.demo.biz.time.AlienUniverseTimeZone.DAYS_OF_YEAR;

public enum MONTH {
    MONTH_1(1, 44),
    MONTH_2(2, 42),
    MONTH_3(3, 48),
    MONTH_4(4, 40),
    MONTH_5(5, 48),
    MONTH_6(6, 44),
    MONTH_7(7, 40),
    MONTH_8(8, 44),
    MONTH_9(9, 42),
    MONTH_10(10, 40),
    MONTH_11(11, 40),
    MONTH_12(12, 42),
    MONTH_13(13, 44),
    MONTH_14(14, 48),
    MONTH_15(15, 42),
    MONTH_16(16, 40),
    MONTH_17(17, 44),
    MONTH_18(18, 38);

    private static final MonthDayInfo[] months;

    static {
        months = Arrays.stream(MONTH.values()).sorted()
                .flatMap(month -> {
                    int days = month.daysOfMonth;
                    MonthDayInfo[] infos = new MonthDayInfo[days];
                    for (int i = 0; i < days; i++) {
                        infos[i] = new MonthDayInfo(month.month, i + 1);
                    }
                    return Stream.of(infos);
                })
                .sorted((a, b) -> {
                    if (a.getMonthOfYear() == b.getMonthOfYear()) {
                        return a.getDayOfMonth() - b.getDayOfMonth();
                    }
                    return a.getMonthOfYear() - b.getMonthOfYear();
                })
                .toList()
                .toArray(new MonthDayInfo[DAYS_OF_YEAR]);
    }

    public static MonthDayInfo of(int dayInYear) {
        return months[dayInYear - 1];
    }

    private int month;
    private int daysOfMonth;

    private MONTH(int month, int daysOfMonth) {
        this.month = month;
        this.daysOfMonth = daysOfMonth;
    }

    public int getMonth() {
        return this.month;
    }

    public int getValue() {
        return this.daysOfMonth;
    }

}

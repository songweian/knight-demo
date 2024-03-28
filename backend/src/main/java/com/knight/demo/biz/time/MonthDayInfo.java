package com.knight.demo.biz.time;

public class MonthDayInfo {
    private int monthOfYear;
    private int dayOfMonth;

    public MonthDayInfo(int monthOfYear, int dayOfMonth) {
        this.monthOfYear = monthOfYear;
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }
}

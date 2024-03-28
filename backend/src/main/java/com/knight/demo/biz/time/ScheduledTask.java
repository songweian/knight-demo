package com.knight.demo.biz.time;

public class ScheduledTask implements Comparable<ScheduledTask> {
    private Runnable runnable;
    private UniverseInstant instant;

    public ScheduledTask(UniverseInstant instant, Runnable runnable) {
        this.instant = instant;
        this.runnable = runnable;
    }

    public UniverseInstant getInstant() {
        return instant;
    }

    public void run() {
        System.out.print("Task at " + instant + "  ");
        runnable.run();
    }

    @Override
    public int compareTo(ScheduledTask o) {
        return o.instant.compareTo(this.instant);
    }

}

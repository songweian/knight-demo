package com.knight.demo.biz.time;

import java.util.PriorityQueue;

public class TimeScheduler {

    private final PriorityQueue<ScheduledTask> tasks = new PriorityQueue<>();
    private final Thread workerThread;

    public TimeScheduler() {
        workerThread = new Thread(() -> {
            for (; ; ) {
                ScheduledTask task = null;
                synchronized (tasks) {
                    task = tasks.peek();
                    if (task == null) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        continue;
                    }
                    UniverseDuration universeDuration = UniverseDuration.of(UniverseInstant.now(), task.getInstant());
                    long delaySeconds = universeDuration.toUniverseUTCSeconds();
                    if (delaySeconds > 0) {
                        try {
                            Thread.sleep(delaySeconds);
                        } catch (InterruptedException e) {
                        }
                        continue;
                    }
                    tasks.poll();
                }

                task.run();
            }
        });
        workerThread.setDaemon(false);
    }

    public void addTask(UniverseInstant instant, Runnable task) {
        synchronized (tasks) {
            tasks.add(new ScheduledTask(instant, task));
        }
        workerThread.interrupt();
    }

    public void waitForCompletion() {
//        try {
//            workerThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void start() {
        workerThread.start();
    }

    public static void main(String[] args) {
        TimeScheduler timeScheduler = new TimeScheduler();
        timeScheduler.start();
        timeScheduler.addTask(UniverseInstant.of(34), () -> System.out.println("Task 1"));
        timeScheduler.addTask(UniverseInstant.of(-1), () -> System.out.println("Task 2"));
        timeScheduler.addTask(UniverseInstant.of(UniverseInstant.now().getTime() + 10000), () -> System.out.println("Task delay 10"));
        timeScheduler.addTask(UniverseInstant.of(UniverseInstant.now().getTime() + 5000), () -> System.out.println("Task delay 5"));
    }
}

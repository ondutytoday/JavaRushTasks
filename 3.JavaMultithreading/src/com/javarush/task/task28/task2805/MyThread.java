package com.javarush.task.task28.task2805;


public class MyThread extends Thread {

    private static int priority = 0;
    private static int threadInitNumber;

    public MyThread() {
        this(null, null, "Thread-" + nextThreadNum(), 0);
    }

    public MyThread(Runnable target) {
        this(null, target, "Thread-" + nextThreadNum(), 0);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        this(group, target, "Thread-" + nextThreadNum(), 0);
    }

    public MyThread(String name) {
        this(null, null, name, 0);
    }

    public MyThread(ThreadGroup group, String name) {
        this(group, null, name, 0);
    }

    public MyThread(Runnable target, String name) {
        this(null, target, name, 0);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        this(group, target, name, 0);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        int thisPriority = getPriorityLoop();
        if (group != null) {
            if (thisPriority <= group.getMaxPriority()) this.setPriority(thisPriority);
            else this.setPriority(group.getMaxPriority());
        } else this.setPriority(thisPriority);
    }

    private static synchronized int nextThreadNum() {
        return threadInitNumber++;
    }

    private int getPriorityLoop() {
        priority++;
        if (priority > 10) priority = 1;
        return priority;
    }
}

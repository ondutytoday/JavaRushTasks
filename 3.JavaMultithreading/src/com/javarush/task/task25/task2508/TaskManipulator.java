package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    private Thread thread;

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread =  new Thread(this, threadName);
        this.threadName = threadName;
        thread.start();

    }

    @Override
    public void stop() {
        try {

            this.thread.interrupt();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}

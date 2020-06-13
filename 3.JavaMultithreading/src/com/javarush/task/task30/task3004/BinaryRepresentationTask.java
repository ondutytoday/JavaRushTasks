package com.javarush.task.task30.task3004;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private final int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        //List<BinaryRepresentationTask> subTasks = new LinkedList<>();
        if (b>0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            result = task.join() + a;
            //subTasks.add(task);
        }

        return result;
    }
}

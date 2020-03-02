package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

    public static class TestThread implements Runnable {

        static  {
            System.out.println("it's a static block inside TestThread");
        }
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
}

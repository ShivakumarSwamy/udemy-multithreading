package com.section2;

public class Lesson5 {

    public static void main(String[] args) {
        Thread workerThread = new WorkerThread();
        workerThread.start();
    }

    private static class WorkerThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello from '" + this.getName() + "'");
        }
    }
}

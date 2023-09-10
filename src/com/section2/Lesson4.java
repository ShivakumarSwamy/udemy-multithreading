package com.section2;

public class Lesson4 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in the new thread '" + Thread.currentThread().getName() + "'");
                System.out.println("Current Thread priority is " + Thread.currentThread().getPriority());

                throw new RuntimeException("Intentional Exception");
            }
        });
        thread.setName("Worker");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in the thread '" + t.getName() + "'" + " the error is "
                + e.getMessage());
            }
        });
        System.out.println("We are in thread '" + Thread.currentThread().getName() + "' before starting a new thread");
        thread.start();
        System.out.println("We are in thread '" + Thread.currentThread().getName() + "' after starting a new thread");

//        Thread.sleep(10000);
    }
}

package com.section2.exercise;

import java.util.List;

public class MultiExecutor {

    private final List<Runnable> tasks;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        for (int i = 0; i < tasks.size(); i++) {
            new Thread(tasks.get(i)).start();
        }
    }
}

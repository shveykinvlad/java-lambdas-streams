package com.nx.dev;

import com.nx.dev.task.TaskProducer;
import com.nx.dev.thread.ThreadExecutor;

/**
 * Main class.
 */
public class Application {

    public static void main(String[] args) {
        ThreadExecutor.executeTask(TaskProducer.createPrintTask());
        ThreadExecutor.executeTask(TaskProducer.createSleepTask());
    }
}

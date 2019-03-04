package com.nx.dev;

import com.nx.dev.task.TaskProducer;
import com.nx.dev.thread.ThreadUtils;

/**
 * Main class.
 */
public class Application {

    public static void main(String[] args) {
        ThreadUtils.executeTask(TaskProducer.createPrintTask());
        ThreadUtils.executeTask(TaskProducer.createSleepTask());
    }
}

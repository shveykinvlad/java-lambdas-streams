package com.nx.dev.thread;

import lombok.experimental.UtilityClass;

/**
 * Manipulations with concurrency.
 */
@UtilityClass
public class ThreadExecutor {

    public static void executeTask(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

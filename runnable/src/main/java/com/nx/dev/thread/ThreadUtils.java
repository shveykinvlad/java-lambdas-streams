package com.nx.dev.thread;

import lombok.experimental.UtilityClass;

/**
 * Manipulations with concurrency.
 */
@UtilityClass
public class ThreadUtils {

    public static void executeTask(Runnable runnable) {
        var thread = new Thread(runnable);
        thread.start();
    }
}

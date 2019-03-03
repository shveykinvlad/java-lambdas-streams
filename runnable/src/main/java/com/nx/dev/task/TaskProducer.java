package com.nx.dev.task;

import static java.lang.Thread.sleep;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Producer of runnable tasks.
 */
@UtilityClass
@Log4j2
public class TaskProducer {

    private static final Long SLEEP_TIME = 3000L;

    public static Runnable createPrintTask() {
        return () -> log.info("Executing print task");
    }

    public static Runnable createSleepTask() {
        log.info("Executing sleep task");
        return () -> {
            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        };
    }
}

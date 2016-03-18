package com.dakhniy.benchmark;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * Created by Sergiy_Dakhniy
 */
public class BenchmarkResult {
    private long memoryUsed;
    private long timeUsed;
    private String[] taskNames;

    public BenchmarkResult(long memoryUsed, long timeUsed, String ... taskNames) {
        this.memoryUsed = memoryUsed;
        this.timeUsed = timeUsed;
        this.taskNames = taskNames;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public long getTimeUsed() {
        return timeUsed;
    }



    public String toString() {
        StringBuilder builder = new StringBuilder("Tasks performed: ");
        for(String taskName : taskNames) {

        }
        builder.append(String.format(""))
        output += String.format("- Memory used: %,d bytes \n", memoryUsed);
        Duration duration = new Duration(timeUsed);
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .printZeroAlways()
                .appendMinutes()
                .appendSuffix(":")
                .appendSeconds()
                .appendSuffix(".")
                .appendMillis()
                .toFormatter();
        output += String.format(" - Time used: %s \n\n", formatter.print(duration.toPeriod()));
        return output;
    }
}

package com.dakhniy.benchmark;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.Map;

/**
 * Created by Sergiy_Dakhniy
 */
public class BenchmarkResult {
    private long memoryUsed;
    private long timeUsed;

    public BenchmarkResult(long memoryUsed, long timeUsed) {
        this.memoryUsed = memoryUsed;
        this.timeUsed = timeUsed;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public long getTimeUsed() {
        return timeUsed;
    }



}

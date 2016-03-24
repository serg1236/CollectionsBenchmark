package com.dakhniy.benchmark;

/**
 * Created by Sergiy_Dakhniy
 */
public class BenchmarkResult {
    private final long memoryUsed;
    private final long timeUsed;

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

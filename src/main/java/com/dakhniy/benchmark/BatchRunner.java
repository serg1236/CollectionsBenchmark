package com.dakhniy.benchmark;

import org.apache.commons.io.FileUtils;
import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sergiy_Dakhniy
 */
public class BatchRunner{

    private boolean printToConsole = true;
    private boolean printToFile = false;
    File file;

    public void run(Object[] taskContainers, String[] taskNames) {
        CollectionBenchmark benchmark = new CollectionBenchmark();
        for(Object taskContainer: taskContainers) {
            Map<String, BenchmarkResult> results = benchmark.init(taskContainer).measure(taskNames);
            String resultString = resultsToString(results, taskContainer);
            if(printToConsole) {
                consolePrinter(resultString);
            }
            if(printToFile) {
                filePrinter(resultString);
            }
        }
    }

    public BatchRunner printToConsole(boolean printToConsole) {
        this.printToConsole = printToConsole;
        return this;
    }

    public BatchRunner printToFile(String fileName) {
        this.printToFile = true;
        file = new File(fileName);
        if(file.exists()) {
            if(!file.delete()){
                throw new RuntimeException("Cannot delete file");
            }
        }
        try {
            if(!file.createNewFile()){
                throw new RuntimeException("Cannot create file");
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    private String resultsToString(Map<String, BenchmarkResult> results, Object taskContainer) {
        String pattern = "%-30s %-30s %-30s\n";
        StringBuilder builder = new StringBuilder(taskContainer.toString()+ ":\n");
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .printZeroAlways()
                .appendMinutes()
                .appendSuffix(":")
                .appendSeconds()
                .appendSuffix(".")
                .appendMillis3Digit()
                .toFormatter();
        builder.append(String.format(pattern, "Task name", "Time used", "Memory Used (bytes)"));
        for(String taskName: results.keySet()) {
            BenchmarkResult result = results.get(taskName);
            Duration duration = new Duration(result.getTimeUsed());
            String time = formatter.print(duration.toPeriod());
            String memory = String.format("%,d", result.getMemoryUsed());
            builder.append(String.format(pattern, taskName, time, memory));
        }
        return builder.toString();
    }

    private void consolePrinter(String result) {
        System.out.println(result);
    }

    private void filePrinter(String result) {
        try {
            FileUtils.writeStringToFile(file, result, true);
            FileUtils.writeStringToFile(file, "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

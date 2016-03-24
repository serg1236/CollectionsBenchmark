package com.dakhniy.benchmark;

import com.dakhniy.benchmark.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Sergiy_Dakhniy
 */
public class CollectionBenchmark {

    private final Map<String, Method> methods = new HashMap<>();
    private Object targetObject;

    public CollectionBenchmark init(Object taskHolder) {
        targetObject = taskHolder;
        Class clazz = taskHolder.getClass();
        initMethods(clazz);
        return this;
    }

    private void initMethods(Class clazz) {
        Method[] objMethods = clazz.getDeclaredMethods();
        for(Method method: objMethods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for(Annotation annotation: annotations) {
                if(annotation instanceof BenchmarkTask) {
                    method.setAccessible(true);
                    String taskName = ((BenchmarkTask)annotation).value();
                    methods.put(taskName, method);
                }
            }
        }
    }

    private void executeTask(String taskName) {
        Method method = methods.get(taskName);
        if(method != null) {
            try {
                method.invoke(targetObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.printf("Task [%s] threw an exception:", taskName);
                e.getTargetException().printStackTrace();
            }
        } else {
            String message = String.format("Task %s does not exist. ", taskName);
            throw new RuntimeException(message);
        }
    }

    public Map<String, BenchmarkResult> measure(String ... taskNames){
        Runtime runtime = Runtime.getRuntime();
        Map<String, BenchmarkResult> results = new LinkedHashMap<>();
        runtime.gc();
        for(String taskName: taskNames) {
            System.out.printf("[%s] Executing %s \n", targetObject.toString(), taskName);
            long millis = System.currentTimeMillis();
            long memBefore = runtime.totalMemory() - runtime.freeMemory();
            executeTask(taskName);
            long timeUsed = System.currentTimeMillis() - millis;
            long memAfter = runtime.totalMemory() - runtime.freeMemory();
            long memoryUsed = memAfter - memBefore;
            results.put(taskName, new BenchmarkResult(memoryUsed, timeUsed));
        }
        return results;
    }

    public Map<String, BenchmarkResult> measure() {
        Set<String> keySet = methods.keySet();
        return measure(keySet.toArray(new String[keySet.size()]));
    }

}

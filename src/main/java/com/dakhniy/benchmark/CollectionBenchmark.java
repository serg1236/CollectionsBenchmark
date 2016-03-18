package com.dakhniy.benchmark;

import com.dakhniy.benchmark.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergiy_Dakhniy
 */
public class CollectionBenchmark {

    private Map<String, Method> methods = new HashMap<String, Method>();
    private Object targetObject;

    public CollectionBenchmark(Object object) {
        targetObject = object;
        Class clazz = object.getClass();
        initMethods(clazz);
    }

    private void initMethods(Class clazz) {
        Method[] objMethods = clazz.getDeclaredMethods();
        for(Method method: objMethods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for(Annotation annotation: annotations) {
                if(annotation instanceof BenchmarkTask) {
                    method.setAccessible(true);
                    String taskName = ((BenchmarkTask)annotation).name();
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

    public BenchmarkResult measure(String ... taskNames){
        Runtime runtime = Runtime.getRuntime();
        long millis = System.currentTimeMillis();
        long mem = runtime.freeMemory();
        for(String taskName: taskNames) {
            executeTask(taskName);
        }
        long memoryUsed = mem - runtime.freeMemory();
        long timeUsed = System.currentTimeMillis() - millis;
        return new BenchmarkResult(memoryUsed, timeUsed, taskNames);
    }
}

package com.dakhniy.benchmark.task;

import com.dakhniy.benchmark.ObjectFactory;
import com.dakhniy.benchmark.annotation.BenchmarkTask;

import java.util.Map;
import java.util.Set;

/**
 * Created by Sergiy_Dakhniy
 */
public class MapTask<T> {
    private Map<Integer, T> map;
    private ObjectFactory<T> factory;

    public MapTask (Map<Integer, T> map, ObjectFactory<T> factory) {
        this.map = map;
        this.factory = factory;
    }

    @BenchmarkTask("Put")
    public void add() {
        for(int i=0; i< 10000000; i++) {
            map.put(i, factory.getObject());
        }
    }


    @BenchmarkTask("GetExists")
    public void getExists() {
        for(int i=0; i< 1000000; i++) {
            map.get(i);
        }
    }

    @BenchmarkTask("GetNotExists")
    public void getNotExists() {
        for(int i=0; i< 1000000; i++) {
            map.get(-1);
        }
    }

    @BenchmarkTask("Remove")
    public void remove() {
        for(int i=0; i< 10000000; i++) {
            map.remove(i);
        }
    }


    @Override
    public String toString() {
        return "Task batch for " + map.getClass().getSimpleName();
    }
}

package com.dakhniy.benchmark.task;

import com.dakhniy.benchmark.factory.ObjectFactory;
import com.dakhniy.benchmark.annotation.BenchmarkTask;

import java.util.Set;

/**
 * Created by Sergiy_Dakhniy
 */
public class SetTask<T> {
    private final Set<T> set;
    private final ObjectFactory<T> factory;

    public SetTask (Set<T> set, ObjectFactory<T> factory) {
        this.set = set;
        this.factory = factory;
    }

    @BenchmarkTask("Add")
    public void add() {
        for(long i=0; i< 1000000; i++) {
            set.add(factory.getObject());
        }
    }


    @BenchmarkTask("ContainsFalse")
    public void containsFalse() {
        for(long i=0; i< 1000000; i++) {
            set.contains(factory.getObject());
        }
    }

    @BenchmarkTask("ContainsTrue")
    public void containsTrue() {
        T obj = factory.getObject();
        set.add(obj);
        for(long i=0; i< 1000000; i++) {
            set.contains(factory.getObject());
        }
    }

    @Override
    public String toString() {
        return "Task batch for " + set.getClass().getSimpleName();
    }

}

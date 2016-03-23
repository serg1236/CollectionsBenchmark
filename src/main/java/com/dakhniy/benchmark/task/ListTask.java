package com.dakhniy.benchmark.task;

import com.dakhniy.benchmark.ObjectFactory;
import com.dakhniy.benchmark.annotation.BenchmarkTask;

import java.util.List;

/**
 * Created by Sergiy_Dakhniy
 */
public class ListTask<T> {
    private List<T> list;
    private ObjectFactory<T> factory;

    public ListTask (List<T> list, ObjectFactory<T> factory) {
        this.list = list;
        this.factory = factory;
    }

    @BenchmarkTask("AddToTail")
    public void addToTail() {
        for(int i =0; i< 10000000; i++) {
            list.add(factory.getObject());
        }
    }

    @BenchmarkTask("AddToHead")
    public void addToHead() {
        for(int i =0; i< 100000; i++) {
            list.add(0,factory.getObject());
        }
    }

    @BenchmarkTask("RemoveFromHead")
    public void removeFromHead() {
        for(int i =0; i< 500 ; i++) {
            list.remove(0);
        }
    }

    @BenchmarkTask("GetFromTail")
    public void getFromTail() {
        for(int i =0; i< 100000 ; i++) {
            list.get(list.size()-1);
        }
    }

    @BenchmarkTask("GetFromMiddle")
    public void getFromMiddle() {
        for(int i =0; i< 500 ; i++) {
            list.get(list.size()/2);
        }
    }


    @Override
    public String toString() {
        return "Task batch for " + list.getClass().getSimpleName();
    }
}

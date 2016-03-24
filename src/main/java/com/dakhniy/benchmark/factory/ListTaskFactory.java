package com.dakhniy.benchmark.factory;

import com.dakhniy.benchmark.task.ListTask;

import java.util.*;

/**
 * Created by Sergiy_Dakhniy
 */
public class ListTaskFactory<T> {
    private final ObjectFactory<T> factory;
    public ListTaskFactory(ObjectFactory<T> factory) {
        this.factory = factory;
    }
    public ListTask<T> getArrayListTask() {
        return new ListTask<>(new ArrayList<>(), factory);
    }
    public ListTask<T> getLinkedListTask() {
        return new ListTask<>(new LinkedList<>(), factory);
    }
    public ListTask<T> getVectorTask() {
        return new ListTask<>(new Vector<>(), factory);
    }
}

package com.dakhniy.benchmark.factory;

import com.dakhniy.benchmark.task.MapTask;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sergiy_Dakhniy
 */
public class MapTaskFactory<T> {
    private final ObjectFactory<T>  factory;
    public MapTaskFactory(ObjectFactory<T> factory) {
        this.factory = factory;
    }
    public MapTask<T> getHashMapTask() {
        return new MapTask<>(new HashMap<>(), factory);
    }
    public MapTask<T> getTreeMapTask() {
        return new MapTask<>(new TreeMap<>(), factory);
    }
    public MapTask<T> getLinkedHashMapTask() {
        return new MapTask<>(new LinkedHashMap<>(), factory);
    }
    public MapTask<T> getConcurrentMapTask() {
        return new MapTask<>(new ConcurrentHashMap<>(), factory);
    }
    public MapTask<T> getObject2ObjectOpenHashMapTask() {
        return new MapTask<>(new Object2ObjectOpenHashMap<>(), factory);
    }
    public MapTask<T> getObject2ObjectAVLTreeMapTask() {
        return new MapTask<>(new Object2ObjectAVLTreeMap<>(), factory);
    }
}

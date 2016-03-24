package com.dakhniy.benchmark.factory;

import com.dakhniy.benchmark.task.SetTask;
import it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Sergiy_Dakhniy
 */
public class SetTaskFactory<T> {
    private final ObjectFactory<T> factory;
    public SetTaskFactory(ObjectFactory<T> factory) {
        this.factory = factory;
    }
    public SetTask<T> getHashSetTask() {
        return new SetTask<>(new HashSet<>(), factory);
    }
    public SetTask<T> getTreeSetTask() {
        return new SetTask<>(new TreeSet<>(), factory);
    }
    public SetTask<T> getLinkedHashSetTask() {
        return new SetTask<>(new LinkedHashSet<>(), factory);
    }
    public SetTask<T> getConcurrentSetTask() {
        return new SetTask<>(new ConcurrentSkipListSet<>(), factory);
    }
    public SetTask<T> getObjectOpenHashSetTask() {
        return new SetTask<>(new ObjectOpenHashSet<>(), factory);
    }
    public SetTask<T> getObjectAVLTreeSetTask() {
        return new SetTask<>(new ObjectAVLTreeSet<>(), factory);
    }
}

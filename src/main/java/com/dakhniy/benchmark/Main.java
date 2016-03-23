package com.dakhniy.benchmark;

import com.dakhniy.benchmark.stub.StubObject;
import com.dakhniy.benchmark.task.ListTask;
import com.dakhniy.benchmark.task.MapTask;
import com.dakhniy.benchmark.task.SetTask;
import it.unimi.dsi.fastutil.objects.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Sergiy_Dakhniy
 */
public class Main {

    public static void main(String[] args) {
        ObjectFactory<StubObject> stringFactory = new ObjectFactory<StubObject>() {
            public StubObject getObject() {
                return new StubObject();
            }
        };
        BatchRunner listRunner = new BatchRunner().printToConsole(true).printToFile("lists.txt");

        //run list tasks
        ListTask<StubObject> arrayListTask = new ListTask<StubObject>(new ArrayList<StubObject>(), stringFactory);
        ListTask<StubObject> linkedListTask = new ListTask<StubObject>(new LinkedList<StubObject>(), stringFactory);
        ListTask<StubObject> vectorTask = new ListTask<StubObject>(new Vector<>(), stringFactory);
        listRunner.run(new Object[]{arrayListTask, linkedListTask, vectorTask}, new String[]{"AddToHead", "AddToTail","RemoveFromHead", "GetFromTail", "GetFromMiddle"});

/*        //run map tasks
        BatchRunner mapRunner = new BatchRunner().printToConsole(true).printToFile("maps.txt");

        MapTask<StubObject> hashMapTask = new MapTask<>(new HashMap<>(), stringFactory);
        MapTask<StubObject> treeMapTask = new MapTask<>(new TreeMap<>(), stringFactory);
        MapTask<StubObject> linkedHashMapTask = new MapTask<>(new LinkedHashMap<>(), stringFactory);
        MapTask<StubObject> concurrentMapTask = new MapTask<>(new ConcurrentHashMap<>(), stringFactory);
        MapTask<StubObject> fastutilMapTask1 = new MapTask<>( new Object2ObjectOpenHashMap<>(), stringFactory);
        MapTask<StubObject> fastutilMapTask2 = new MapTask<>( new Object2ObjectAVLTreeMap<>(), stringFactory);
        mapRunner.run(new Object[]{hashMapTask, treeMapTask, linkedHashMapTask, concurrentMapTask, fastutilMapTask1, fastutilMapTask2},
                new String[]{"Put", "GetExists", "GetNotExists", "Remove"});

        //run set tasks
        BatchRunner setRunner = new BatchRunner().printToConsole(true).printToFile("sets.txt");

        SetTask<StubObject> hashSetTask = new SetTask<>(new HashSet<>(), stringFactory);
        SetTask<StubObject> treeSetTask = new SetTask<>(new TreeSet<>(), stringFactory);
        SetTask<StubObject> linkedHashSetTask = new SetTask<>(new LinkedHashSet<>(), stringFactory);
        SetTask<StubObject> concurrentSetTask = new SetTask<>(new ConcurrentSkipListSet<>(), stringFactory);
        SetTask<StubObject> fastutilSetTask1 = new SetTask<>( new ObjectOpenHashSet<>(), stringFactory);
        SetTask<StubObject> fastutilSetTask2 = new SetTask<>( new ObjectAVLTreeSet<>(), stringFactory);
        setRunner.run(new Object[]{hashSetTask, treeSetTask, linkedHashSetTask, concurrentSetTask, fastutilSetTask1, fastutilSetTask2},
                new String[]{"Add", "ContainsFalse", "ContainsTrue"});*/
    }




}

package com.dakhniy.benchmark;

import com.dakhniy.benchmark.factory.ListTaskFactory;
import com.dakhniy.benchmark.factory.MapTaskFactory;
import com.dakhniy.benchmark.factory.SetTaskFactory;
import com.dakhniy.benchmark.stub.StubObject;

/**
 * Created by Sergiy_Dakhniy
 */
public class Main {

    public static void main(String[] args) {
        testLists();
        testMaps();
        testSets();
    }

    private static void testLists() {
        ListTaskFactory<StubObject> factory = new ListTaskFactory<>(StubObject::new);
        BatchRunner listRunner = new BatchRunner().printToConsole(true).printToFile("lists.txt");
        Object[] taskContainers = new Object[] {
                factory.getArrayListTask(),
                factory.getLinkedListTask(),
                factory.getVectorTask()
        };
        String[] taskSequence = new String[]{"AddToHead", "AddToTail","RemoveFromHead", "GetFromTail", "GetFromMiddle"};
        listRunner.run(taskContainers, taskSequence);
    }

    private static void testMaps() {
        MapTaskFactory<StubObject> factory = new MapTaskFactory<>(StubObject::new);
        BatchRunner mapRunner = new BatchRunner().printToConsole(true).printToFile("maps.txt");
        Object[] taskContainers = new Object[] {
                factory.getHashMapTask(),
                factory.getLinkedHashMapTask(),
                factory.getTreeMapTask(),
                factory.getConcurrentMapTask(),
                factory.getObject2ObjectAVLTreeMapTask(),
                factory.getObject2ObjectOpenHashMapTask()
        };
        String[] taskSequence = new String[]{"Put", "GetExists", "GetNotExists", "Remove"};
        mapRunner.run(taskContainers, taskSequence);
    }

    private static void testSets() {
        SetTaskFactory<StubObject> factory = new SetTaskFactory<>(StubObject::new);
        BatchRunner setRunner = new BatchRunner().printToConsole(true).printToFile("sets.txt");
        Object[] taskContainers = new Object[] {
                factory.getHashSetTask(),
                factory.getTreeSetTask(),
                factory.getLinkedHashSetTask(),
                factory.getConcurrentSetTask(),
                factory.getObjectAVLTreeSetTask(),
                factory.getObjectOpenHashSetTask()
        };
        String[] taskSequence = new String[]{"Add", "ContainsFalse", "ContainsTrue"};
        setRunner.run(taskContainers, taskSequence);
    }


}

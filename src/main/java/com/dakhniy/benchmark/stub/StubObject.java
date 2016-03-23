package com.dakhniy.benchmark.stub;

/**
 * Created by Sergiy_Dakhniy
 */
public class StubObject implements Comparable<StubObject>{
    private String name = "stub";
    private Double number = Math.random();

    @Override
    public int compareTo(StubObject o) {
        if(this == o) {
            return 0;
        } else if(this.number > o.number) {
            return 1;
        } else return 1;
    }
}

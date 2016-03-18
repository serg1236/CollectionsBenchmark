package com.dakhniy.benchmark;

/**
 * Created by Sergiy_Dakhniy
 */
public class Main {

    public static void main(String[] args) {
        ObjectFactory<String> stringObjectFactory = new ObjectFactory<String>() {
            public String getObject() {
                return "Hellooooooooooo!";
            }
        };
    }
}

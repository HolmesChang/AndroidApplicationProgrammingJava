package com.example.samplexxx_intent;

import java.io.Serializable;

public class MyData implements Serializable {
    String name;
    int age;
    String id;

    public MyData (String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
}

package com.company;

public class Soccer implements Sport {
    final private String name = "Soccer";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

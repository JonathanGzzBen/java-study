package com.company;

public class Basketball implements Sport {
    final private String name = "Basketball";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

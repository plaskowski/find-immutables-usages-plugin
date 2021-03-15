package com.example;

import org.immutables.value.Value;

public class OtherExamples {

    public static void main(String[] args) {

    }

    @Value.Immutable(builder = false)
    interface ObjectWithoutBuilder {
        String getProperty();
    }

}

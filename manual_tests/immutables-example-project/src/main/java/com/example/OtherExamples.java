package com.example;

import org.immutables.builder.Builder;
import org.immutables.value.Value;

import java.util.List;

public class OtherExamples {

    public static void main(String[] args) {
        new ListOfThreeBuilder()
                .first(1)
                .second(3)
                .third(5)
                .build();
    }

    @Value.Immutable(builder = false)
    interface ObjectWithoutBuilder {
        @Value.Parameter
        String getProperty();
    }

    @Builder.Factory
    public static List<Integer> listOfThree(Integer first, Integer second, Integer third) {
        return List.of(first, second, third);
    }

}

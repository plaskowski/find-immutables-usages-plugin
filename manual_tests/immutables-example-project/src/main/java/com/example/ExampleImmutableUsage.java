package com.example;

public class ExampleImmutableUsage {

    public static void main(String[] args) {
        ImmutableSomeObject a = createObjectUsingBuilder();
        SomeObject b = createCopyUsingWithMethod(a);
    }

    private static ImmutableSomeObject createObjectUsingBuilder() {
        return ImmutableSomeObject.builder()
                .firstProperty("Abc")
                .build();
    }

    private static ImmutableSomeObject createCopyUsingWithMethod(
            ImmutableSomeObject a) {
        return a.withFirstProperty("B");
    }

}

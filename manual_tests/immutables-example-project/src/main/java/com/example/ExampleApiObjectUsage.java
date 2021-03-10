package com.example;

public class ExampleApiObjectUsage {

    public static void main(String[] args) {
        ImmutableMySomeApiObject a = createApiObjectUsingBuilder();
        SomeApiObject b = createApiObjectCopyUsingWithMethod(a);
    }

    private static ImmutableMySomeApiObject createApiObjectUsingBuilder() {
        return ImmutableMySomeApiObject.builder()
                .firstProperty("Abc")
                .build();
    }

    private static SomeApiObject createApiObjectCopyUsingWithMethod(
            ImmutableMySomeApiObject a) {
        return a.withFirstProperty("B");
    }

}

package com.example;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface SomeObject {
    String getFirstProperty();
    String code();
    List<Long> getIdList();
}

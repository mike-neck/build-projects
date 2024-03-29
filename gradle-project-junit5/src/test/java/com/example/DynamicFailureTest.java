package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DynamicFailureTest {

    @BeforeEach
    void setup() {}

    @TestFactory
    Iterable<DynamicTest> tests() {
        return () -> new Iterator<>() {
            @Override
            public boolean hasNext() {
                throw new IllegalStateException("test");
            }

            @Override
            public DynamicTest next() {
                throw new NoSuchElementException("test");
            }
        };
    }
}

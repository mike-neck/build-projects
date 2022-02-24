package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Iterator;

class MavenDynamicFailureTest {

    @BeforeEach
    void setup() {}

    @TestFactory
    Iterable<DynamicTest> tests() {
        return new Iterable<DynamicTest>() {
            @Override
            public Iterator<DynamicTest> iterator() {
                throw new IllegalStateException("test");
            }
        };
    }
}

package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MavenFailureTest {

    @Test
    void failureTest() {
        assertEquals(1, 2);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals(2, 4),
                () -> assertEquals("foo", "foo"),
                () -> assertEquals("bar", "baz")
        );
    }
}

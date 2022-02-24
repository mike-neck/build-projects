package com.example;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MavenNormalTest {

    @Test
    void normalAssertion() {
        assertEquals(1, 1);
    }

    @Test
    void assertionByAssertAll() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals("foo", "foo")
        );
    }

    @TestFactory
    Iterable<DynamicTest> testByDynamic() {
        return List.of(
                DynamicTest.dynamicTest("1st", () -> assertEquals(1, 1)),
                DynamicTest.dynamicTest("2nd", () -> assertEquals("foo", "foo"))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 200})
    void parameterTest(int value) {
        int plus1 = value + 1;
        assertEquals(value * value + 2 * value + 1, plus1 * plus1);
    }
}

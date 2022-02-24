package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MavenNormalFailureTest {

    @Test
    void failureTest() {
        assertEquals(1, 2);
    }

    @Test
    void assertionByAssertAll() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals(2, 4),
                () -> assertEquals("foo", "foo"),
                () -> assertEquals("bar", "baz")
        );
    }

    @TestFactory
    Iterable<DynamicTest> testByDynamic() {
        return List.of(
                DynamicTest.dynamicTest("1st", () -> assertEquals(1, 1)),
                DynamicTest.dynamicTest("2nd", () -> assertEquals(2, 4)),
                DynamicTest.dynamicTest("3rd", () -> assertEquals("foo", "foo")),
                DynamicTest.dynamicTest("4th", () -> assertEquals("bar", "baz"))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100, 200})
    void parameterTest(int value) {
        assertEquals(2 * value, value * value);
    }

    @Disabled
    @Test
    void skippedTest() {}

    @Test
    @DisplayName("おっぱいブルンブルン")
    void 総統閣下() {
        assertEquals("(　ﾟ∀ﾟ)o彡°おっぱい！おっぱい！ ", "ブルンブルン");
    }

    @Test
    void exception() {
        throw new RuntimeException("test error");
    }

    @Nested
    class Inner {

        @Test
        void failureTest() {
            fail();
        }
    }
}

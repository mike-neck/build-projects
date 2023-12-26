package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NormalFailureTest {

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

    static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .appendValue(ChronoField.HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
            .optionalStart()
            .appendOffsetId()
            .toFormatter();

    @RepeatedTest(10)
    void repeatingTest() {
        var now = Instant.now().atOffset(ZoneOffset.UTC);
        String string = FORMATTER.format(now);
        assertTrue(string.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}Z"), string);
    }

    @RepeatedTest(10)
    void repeatingInfo(RepetitionInfo info) {
        int total = info.getTotalRepetitions();
        int current = info.getCurrentRepetition();
        int last = total - current;
        int min = Math.min(last, current);
        assertNotEquals(0, min % 3, () -> "total: %d current: %d last: %d, min: %d".formatted(
                total, current, last, min
        ));
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

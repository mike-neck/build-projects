package com.example;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TimeTest {

    @Test
    void timeTest() {
        ZoneOffset asiaTokyo = ZoneOffset.ofHours(9);
        OffsetTime time = OffsetTime.of(LocalTime.now(ZoneId.of("Asia/Tokyo")), asiaTokyo);
        OffsetTime base = OffsetTime.of(10, 45, 0, 0, asiaTokyo);
        System.out.println(time);
        System.out.println(base);
        assertFalse(time.isBefore(base));
    }
}

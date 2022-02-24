package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("総統閣下")
 class MavenNameTest {

    @DisplayName("おっぱい")
    @Nested
    class Inner {
        @DisplayName("ぷるんぷるん")
        @Test
        void failure() {
            fail();
        }
    }
}

package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class MavenLifeCycleBeforeEachTest {

    @BeforeEach
    void setup(TestInfo testInfo) {
        testInfo.getTestMethod()
                .ifPresent(method -> {
                    if (method.getName().contains("failure")) {
                        throw new IllegalArgumentException(method.getName());
                    }
                });
    }

    @Test
    void success() {}

    @Test
    void failure() {}

    @Test
    void failureByBeforeEach() {}
}

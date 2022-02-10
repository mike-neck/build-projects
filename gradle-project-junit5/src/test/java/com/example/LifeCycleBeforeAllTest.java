package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class LifeCycleBeforeAllTest {

    @BeforeAll
    static void setup(TestInfo testInfo) {
        testInfo.getTestMethod().get();
    }

    @BeforeEach
    void setupBasic() {}

    @Test
    void failure() {}
}

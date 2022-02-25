package com.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class GradleJUnit4NormalFailureTest {

    @Test
    public void testSimple() {
        assertThat(1, is(2));
    }

    @Test
    public void testSingle() {
        assertThat("foo", is(not("foo")));
    }
}

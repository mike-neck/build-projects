package com.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Enclosed.class)
public class GradleJUnit4StructureTest {

    public static class First {
        @Test
        public void testFailure() {
            assertThat("foo", is("bar"));
        }
    }

    public static class Second {
        @Test
        public void testFailure() {
            assertThat("bar", is("qux"));
        }
    }
}

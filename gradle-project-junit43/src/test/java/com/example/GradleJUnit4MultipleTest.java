package com.example;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Theories.class)
public class GradleJUnit4MultipleTest {

     @DataPoints public static String[] data() {
         return new String[] {
                 "foo",
                 "bar",
                 "baz"
         };
     }

     @Theory
    public void test(String string) {
         assertThat(string, is("FOO"));
     }
}

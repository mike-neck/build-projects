package com.example;

import junit.framework.TestCase;

public class MavenJUnit3NormalFailureTest extends TestCase {

    public void testFailure() {
        assertEquals("bar", "foo");
    }
}

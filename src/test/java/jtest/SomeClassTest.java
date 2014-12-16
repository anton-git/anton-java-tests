package jtest;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * User: Anton
 * Date: 21/09/13
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class SomeClassTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Before class");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before test");

    }

    @Test
    public void getSum() throws Exception {

        assertEquals(1, 1);

        assertThat(1, is(1));

    }
}

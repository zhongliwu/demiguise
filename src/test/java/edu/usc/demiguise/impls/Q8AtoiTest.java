package edu.usc.demiguise.impls;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q8AtoiTest {

    private static final _8Atoi solution = new _8Atoi();

    @Test
    public void testMaxSignedInt() {
        assertEquals(2147483647, solution.myAtoi("2147483647"));
    }

    @Test
    public void testMinSignedInt() {
        assertEquals(-2147483648, solution.myAtoi("-2147483648"));
    }

    @Test
    public void testBigPosInteger() {
        assertEquals(2147483647, solution.myAtoi("4294967296"));
    }

    @Test
    public void testBigNegInteger() {
        assertEquals(-2147483648, solution.myAtoi("-4294967296"));
    }
}

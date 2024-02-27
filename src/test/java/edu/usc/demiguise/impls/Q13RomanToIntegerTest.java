package edu.usc.demiguise.impls;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Q13RomanToIntegerTest {

    private static final _13RomanToInteger solution = new _13RomanToInteger();

    @Test
    public void testSingleRoman() {
        int romanValue = solution.romanToInt("L");
        assertEquals(50, romanValue);
    }

    @Test
    public void testTwoRoman() {
        int romanValue = solution.romanToInt("XC");
        assertEquals(90, romanValue);
    }

    @Test
    public void testOfficialSample() {
        int romanValue = solution.romanToInt("LVIII");
        assertEquals(58, romanValue);
    }
}

package edu.usc.demiguise.twopointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Q3LongestSubstrWoRepeatingCharsTest {

    private static final _3_LongestSubstrWoRepeatingChars solution = new _3_LongestSubstrWoRepeatingChars();

    @Test
    public void testSingleRoman() {
        int maxLen = solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, maxLen);
    }
}

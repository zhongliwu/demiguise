package edu.usc.demiguise.twopointers;

import java.util.HashMap;
import java.util.Map;


public class _3_LongestSubstrWoRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int j = 0, n = s.length(), maxLen = -1;
        int[] map = new int[256];
        for (int i = 0; i < n; i++) {
            while (j < n && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j += 1;
            }

            map[s.charAt(i)] = 0;
        }

        return maxLen;
    }
}

package edu.usc.demiguise.impls;

import java.util.HashMap;
import java.util.Map;

public class _13RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> romanToVal = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int size = s.length(), itr = 0;
        while (itr < size) {
            int value = romanToVal.get(s.charAt(itr));
            if (itr + 1 < size) {
                int nextValue = romanToVal.get(s.charAt(itr + 1));
                if (value < nextValue) {
                    value = nextValue - value;
                    itr += 1;
                }
            }

            result += value;
            itr += 1;
        }

        return result;
    }
}

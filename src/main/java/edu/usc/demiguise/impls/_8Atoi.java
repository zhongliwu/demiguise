package edu.usc.demiguise.impls;

public class _8Atoi {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return 0;
        }

        String buffer = s.trim();
        long result = 0L, pos = 1L;
        int itr = 0, n = buffer.length();
        if (buffer.charAt(0) == '-') {
            pos = -1L;
        }

        if (buffer.charAt(0) == '+' || buffer.charAt(0) == '-') {
            itr = 1;
        }

        for (; itr < n; itr++) {
            int cur = buffer.charAt(itr) - '0';
            if (cur < 0 || cur > 9) {
                break;
            }

            if (isExceeded(result)) {
                break;
            }

            result *= 10;
            result += (long) cur * pos;
        }

        if (result > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    private boolean isExceeded(long result) {
        if (result > (long) Integer.MAX_VALUE) {
            return true;
        }

        if (result < (long) Integer.MIN_VALUE) {
            return true;
        }

        return false;
    }
}

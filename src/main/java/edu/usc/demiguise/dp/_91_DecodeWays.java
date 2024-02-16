package edu.usc.demiguise.dp;


public class _91_DecodeWays {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * numOfDecodeWays(s.substring(i - 1, i));
            if (i >= 2) {
                dp[i] += dp[i - 2] * numOfDecodeWays(s.substring(i - 2, i));
            }
        }

        return n == 0 ? 0 : dp[n];
    }

    private int numOfDecodeWays(String s) {
        int val = Integer.parseInt(s);
        if (s.length() == 1 && val <= 9 && val >= 1) {
            return 1;
        }

        if (s.length() == 2 && val >= 10 && val <= 26) {
            return 1;
        }

        return 0;
    }
}

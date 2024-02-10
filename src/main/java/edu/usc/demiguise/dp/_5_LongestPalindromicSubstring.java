package edu.usc.demiguise.dp;

public class _5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1, beginIdx = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (dp[i][i + 1] && maxLen < 2) {
                maxLen = 2;
                beginIdx = i;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && (length > maxLen)) {
                    maxLen = length;
                    beginIdx = i;
                }
            }
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    public static void main(String[] args) {
        _5_LongestPalindromicSubstring solution = new _5_LongestPalindromicSubstring();
        solution.longestPalindrome("ccc");
    }
}

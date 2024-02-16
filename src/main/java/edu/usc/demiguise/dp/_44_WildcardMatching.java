package edu.usc.demiguise.dp;


public class _44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] & (p.charAt(j - 1) == '*');
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] | dp[i][j - 1]);
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] & matches(s.charAt(i - 1), p.charAt(j - 1)));
                }
            }
        }

        return dp[n][m];
    }

    private boolean matches(char c, char p) {
        return (c == p) || (p == '?');
    }

    public static void main(String[] args) {
        _44_WildcardMatching solution = new _44_WildcardMatching();
        solution.isMatch("a", "aa");
    }
}

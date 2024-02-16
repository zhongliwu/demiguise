package edu.usc.demiguise.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }

                String sub = s.substring(j, i);
                if (wordSet.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

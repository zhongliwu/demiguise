package edu.usc.demiguise.permutations;


public class _t197_permutationIndex {
    public long permutationIndex(int[] a) {
        if (a == null || a.length <= 1) {
            return 1;
        }

        int n = a.length;
        long result = 0;
        long permutations = 1;
        for (int i = n - 2; i >= 0; i--) {
            int smaller = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    smaller++;
                }
            }
            result += smaller * permutations;
            permutations *= n - i;
        }

        return result + 1;
    }
}

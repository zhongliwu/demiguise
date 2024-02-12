package edu.usc.demiguise.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        dfs(nums, visited, permutation, permutations);
        return permutations;
    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            List<Integer> newPerm = new ArrayList<Integer>(permutation);
            permutations.add(newPerm);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, permutations);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}

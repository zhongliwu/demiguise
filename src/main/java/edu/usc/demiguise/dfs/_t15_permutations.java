package edu.usc.demiguise.dfs;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class _t15_permutations {

    private void dfs(int[] nums,
                     Set<Integer> visited,
                     List<Integer> permutation,
                     List<List<Integer>> permutations) {
        if (visited.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }

            visited.add((Integer) num);
            permutation.add(num);
            dfs(nums, visited, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            visited.remove((Integer) num);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null) {
            return permutations;
        }

        if (nums.length == 0) {
            permutations.add(new ArrayList<>());
            return permutations;
        }

        List<Integer> permutation = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(nums, visited, permutation, permutations);
        return permutations;
    }
}

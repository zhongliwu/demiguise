package edu.usc.demiguise.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _46_permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> p = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(p);
            return result;
        }

        Arrays.sort(nums);
        do {
            List<Integer> permut = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(permut);
        } while (nextPermutation(nums));

        return result;
    }

    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1, j = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i -= 1;
        }

        if (i == 0) {
            return false;
        }

        while (j > 0 && nums[j] <= nums[i - 1]) {
            j -= 1;
        }

        swap(nums, i - 1, j);
        reverse(nums, i);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }
}

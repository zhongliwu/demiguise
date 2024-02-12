package edu.usc.demiguise.permutations;

import java.util.List;


public class _t51_previousPermutation {

    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() <= 1) {
            return nums;
        }

        int n = nums.size();
        int i = n - 1;
        while (i > 0 && nums.get(i) >= nums.get(i - 1)) {
            i--;
        }

        if (i > 0) {
            int j = n - 1;
            while (j > 0 && nums.get(j) >= nums.get(i - 1)) {
                j--;
            }
            swap(nums, j, i - 1);
        }

        reverse(nums, i);
        return nums;
    }

    private void swap(List<Integer> nums, int i, int j) {
        Integer tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    private void reverse(List<Integer> nums, int start) {
        int left = start, right = nums.size() - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}

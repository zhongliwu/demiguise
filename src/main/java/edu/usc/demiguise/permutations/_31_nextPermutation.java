package edu.usc.demiguise.permutations;

public class _31_nextPermutation {

    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        int i = n - 1, j = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i -= 1;
        }

        if (i > 0) {
            while (j > 0 && nums[j] <= nums[i - 1]) {
                j -= 1;
            }
            swap(nums, i - 1, j);
        }

        reverse(nums, i);
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

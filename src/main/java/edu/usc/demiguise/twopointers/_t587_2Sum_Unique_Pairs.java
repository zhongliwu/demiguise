package edu.usc.demiguise.twopointers;

import java.util.Arrays;

public class _t587_2Sum_Unique_Pairs {
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int numOfTuples = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int curSum = nums[left] + nums[right];
            if (curSum == target) {
                numOfTuples += 1;
                left += 1;
                right -= 1;

                while (left < right && nums[left] == nums[left - 1]) {
                    left += 1;
                }

                while (left < right && nums[right] == nums[right + 1]) {
                    right -= 1;
                }

            } else if (curSum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return numOfTuples;
    }
}

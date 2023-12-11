package edu.usc.demiguise.twopointers;

public class _75_SortColors {

    public void sortColorsThreePointers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0, end = nums.length -1, itr = 0;
        while (start <= end) {
            while (itr <= end) {
                if (nums[itr] == 0) {
                    swap(nums, itr, start);
                    itr += 1;
                    start += 1;
                } else if (nums[itr] == 2) {
                    swap(nums, itr, end);
                    itr += 1;
                    end -= 1;
                }
            }
        }
    }

    public void sortColorsPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int startOfOne = partition(0, nums.length - 1, nums, 1);
        partition(startOfOne, nums.length - 1, nums, 2);
    }

    private int partition(int left, int right, int[] nums, int pivot) {
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left += 1;
            }

            while (left <= right && nums[right] >= pivot) {
                right -= 1;
            }

            if (left <= right) {
                swap(nums, left, right);
                left += 1;
                right -= 1;
            }
        }

        return left;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

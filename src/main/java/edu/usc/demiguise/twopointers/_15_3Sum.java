package edu.usc.demiguise.twopointers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);
        List<List<Integer>> tuples = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            tuples.addAll(twoSum(-1 * numbers[i], i + 1, numbers));
        }

        return tuples;
    }

    private List<List<Integer>> twoSum(int target, int start, int[] numbers) {
        int left = start, right = numbers.length - 1;
        List<List<Integer>> results = new ArrayList<>();
        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if (curSum > target) {
                right--;
            } else if (curSum < target) {
                left++;
            } else {
                List<Integer> tuples = new ArrayList<>(3);
                tuples.add(-1 * target);
                tuples.add(numbers[left++]);
                tuples.add(numbers[right--]);
                results.add(tuples);
                while (left < right && numbers[left - 1] == numbers[left]) {
                    left += 1;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        _15_3Sum solution = new _15_3Sum();
        List<List<Integer>> rlt = solution.threeSum(new int[]{1, 1, 1, 1, 1, 0, 0, -1});
        for (List<Integer> elem : rlt) {
            for (Integer num : elem) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

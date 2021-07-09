package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

import static leetCode.helperClasses.Utility.print;

public final class TwoSum {
    /**
     * #1 - https://leetcode.com/problems/two-sum/
     * <p>
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("Answer not found");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        print(twoSum.twoSum(new int[]{-1, -1, 11, 15}, -2));

    }
}

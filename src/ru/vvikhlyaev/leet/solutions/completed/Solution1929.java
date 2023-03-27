package ru.vvikhlyaev.leet.solutions.completed;

import java.util.Arrays;

/**
 * Concatenation of Array
 * <p>
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * <p>
 * Specifically, ans is the concatenation of two nums arrays.
 * <p>
 * Return the array ans.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1]
 * Output: [1,2,1,1,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * Example 2:
 * <p>
 * Input: nums = [1,3,2,1]
 * Output: [1,3,2,1,1,3,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 */
public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        if (nums.length == 0)
            return nums;

        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        test(1, 2, 1);
    }

    public static void test(int... arr) {
        Solution1929 solution1929 = new Solution1929();
        int[] res = solution1929.getConcatenation(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}

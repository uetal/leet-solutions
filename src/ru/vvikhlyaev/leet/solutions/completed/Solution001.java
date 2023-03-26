package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;
/**
 * Two sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class Solution001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i ++) {
            int found = target - nums[i];
            Integer foundIndexInMap = map.get(found);
            if (foundIndexInMap == null) {
                map.put(nums[i], i);
            } else {
                return new int[] {foundIndexInMap, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution001().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution001().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new Solution001().twoSum(new int[]{3, 3}, 6)));
    }
}

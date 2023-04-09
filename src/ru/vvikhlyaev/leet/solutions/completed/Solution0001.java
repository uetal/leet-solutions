package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;

/**
 * Two sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class Solution0001 {

//    public int[] twoSum(int[] nums, int target) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i <nums.length; i ++) {
//            int found = target - nums[i];
//            boolean foundIndexInMap = set.contains(found);
//            if (!foundIndexInMap) {
//                set.add(nums[i]);
//            } else {
//                return new int[] {found, nums[i]};
//            }
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int foundedSum = nums[leftIndex] + nums[rightIndex];
            if (foundedSum == target)
                return new int[]{nums[leftIndex], nums[rightIndex]};
            if (foundedSum > target)
                rightIndex--;
             else
                leftIndex++;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution0001().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution0001().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new Solution0001().twoSum(new int[]{3, 3}, 6)));
    }
}

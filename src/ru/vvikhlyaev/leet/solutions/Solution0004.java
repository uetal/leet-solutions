package ru.vvikhlyaev.leet.solutions;

import static ru.vvikhlyaev.leet.util.Util.testTwoArraysToDouble;

/**
 * TODO не сделал
 * Solution0004
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 */
public class Solution0004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
        double maxLeft = 0, minRight = 0;
        while(imin <= imax){
            i = (imin + imax) / 2;
            j = half - i;
            if(j > 0 && i < m && nums2[j - 1] > nums1[i]){
                imin = i + 1;
            }else if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
                imax = i - 1;
            }else{
                if(i == 0){
                    maxLeft = (double)nums2[j - 1];
                }else if(j == 0){
                    maxLeft = (double)nums1[i - 1];
                }else{
                    maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        if((m + n) % 2 == 1){
            return maxLeft;
        }
        if(i == m){
            minRight = (double)nums2[j];
        }else if(j == n){
            minRight = (double)nums1[i];
        }else{
            minRight = (double)Math.min(nums1[i], nums2[j]);
        }

        return (double)(maxLeft + minRight) / 2;
    }

    public static void main(String[] args) {
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 2, 3}, new int[0], 2.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, new int[0], 9.50000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 3}, new int[0], 2.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[0], new int[]{1, 2}, 1.50000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 2, 3, 4, 5}, new int[]{6, 7}, 4.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{6, 7}, new int[]{1, 2, 3, 4, 5}, 4.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 3}, new int[]{2}, 2.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3}, 3.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 2}, new int[]{2}, 2.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1, 2}, new int[]{3, 4}, 2.50000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{0, 0}, new int[]{0, 0}, 0.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[]{1}, new int[0], 1.00000);
        testTwoArraysToDouble(Solution0004::findMedianSortedArrays, new int[0], new int[]{2}, 2.00000);
    }
}

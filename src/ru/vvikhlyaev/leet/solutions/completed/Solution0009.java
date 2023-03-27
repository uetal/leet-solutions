package ru.vvikhlyaev.leet.solutions.completed;

/**
 * isPalindrome
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 */
class Solution0009 {
    public boolean isPalindrome(int x) {
        String xStringValue = String.valueOf(x);
        String xStringValueReverse = new StringBuilder(xStringValue).reverse().toString();
        return xStringValueReverse.equals(xStringValue);
    }

    public static void main(String[] args) {
        Solution0009 s = new Solution0009();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(10));
    }
}

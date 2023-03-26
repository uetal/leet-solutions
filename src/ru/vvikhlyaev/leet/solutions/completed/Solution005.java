package ru.vvikhlyaev.leet.solutions.completed;

import java.util.Arrays;

/**
 * Solution005
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 */
public class Solution005 {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        char[] palindromeCharArray = new char[0];
        for (int i = 0; i < arr.length; i++) {
            char[] palindrome1 = getPalindromeWithCenter(arr, i, i + 1);
            char[] palindrome2 = getPalindromeWithCenter(arr, i, i);
            if (palindromeCharArray.length < palindrome1.length)
                palindromeCharArray = palindrome1;
            if (palindromeCharArray.length < palindrome2.length)
                palindromeCharArray = palindrome2;
        }
        return String.valueOf(palindromeCharArray);
    }

    private char[] getPalindromeWithCenter(char[] array, int left, int right) {
        while (left >= 0 && right < array.length && array[left] == array[right]) {
            left -= 1;
            right += 1;
        }
        return Arrays.copyOfRange(array, left + 1, right);
    }

    public static void main(String[] args) {
        test("abcdecbced", "decbced");
        test("babad", "bab");
        test("cbbd", "bb");
        test("a", "a");
        test("ac", "a");
        test("bb", "bb");
        test("ccc", "ccc");
        test("aaaa", "aaaa");
    }

    private static void test(String actual, String expected) {
        Solution005 solution005 = new Solution005();
        String actualResult = solution005.longestPalindrome(actual);
        if (!actualResult.equals(expected)) {
            System.err.println("actual: %s, expected: %s".formatted(actualResult, expected));
        }
    }
}

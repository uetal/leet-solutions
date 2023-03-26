package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;
import java.util.stream.Collectors;

import static ru.vvikhlyaev.leet.util.Util.testInputStringOutputInt;

/**
 * Solution003
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class Solution003 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        var arr = Arrays.stream(s.split("")).collect(Collectors.toList());
        int res = 1;
        List<String> strings = new ArrayList<>();
        strings.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            boolean isContains = strings.contains(arr.get(i));
            if (isContains) {
                res = Math.max(strings.size(), res);
                int index = strings.indexOf(arr.get(i));
                while (index >= 0) {
                    strings.remove(strings.get(index--));
                }
            }
            strings.add(arr.get(i));
            res = Math.max(strings.size(), res);

        }

        return res;
    }

    public static void main(String[] args) {
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "wobgrovw", 6);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "bdb", 2);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "anviaj", 5);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "dvdf", 3);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "au", 2);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "abcabcbb", 3);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "bbbbb", 1);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "pwwkew", 3);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, "", 0);
        testInputStringOutputInt(Solution003::lengthOfLongestSubstring, " ", 1);
    }
}

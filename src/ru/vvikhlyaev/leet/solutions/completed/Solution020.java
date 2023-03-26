package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

public class Solution020 {
    public static boolean isValid(String s) {
        Map<String, String> map = Map.of(
                ")","(",
                "]","[",
                "}","{"
        );
        java.util.Collection<String> values = map.values();
        Deque<String> deque = new ArrayDeque<>();
        for (String elem : s.split("")) {
            if (values.contains(elem)) {
                deque.add(elem);
                continue;
            }

            if (!deque.isEmpty() && deque.getLast().equals(map.get(elem))) {
                deque.removeLast();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}

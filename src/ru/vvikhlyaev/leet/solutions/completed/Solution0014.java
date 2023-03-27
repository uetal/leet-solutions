package ru.vvikhlyaev.leet.solutions.completed;

/**
 * longestCommonPrefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        String first = strs[0];
        if (first.isEmpty()) {
            return first;
        }
        String[] firstInArray = first.split("");
        for (int i = firstInArray.length; i >= 0; i--) {
            String prefix = first.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                result = prefix;
                if (!strs[j].startsWith(prefix)) {
                    result = "";
                    break;
                }
            }
            if (!result.isEmpty()) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0014 s = new Solution0014();
        System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(s.longestCommonPrefix(new String[]{""}));
        System.out.println(s.longestCommonPrefix(new String[]{"", ""}));
        System.out.println(s.longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));
    }
}

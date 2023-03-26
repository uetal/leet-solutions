import static ru.vvikhlyaev.leet.util.Util.createCycleToInputStrings;

public class Solution {

    /**
     * Given a string s, reverse the string according to the following rules:
     * <p>
     * All the characters that are not English letters remain in the same position.
     * All the English letters (lowercase or uppercase) should be reversed.
     * Return s after reversing it.
     *
     * @param s
     * @return
     */
    public static String reverseOnlyLetters(String s) {
        String[] chars = s.split("");
        String[] reverseCharsWithoutNumbers = new StringBuilder(s.replaceAll("[^a-zA-Z]", ""))
                .reverse().toString().split("");
        StringBuilder result = new StringBuilder();
        for (int resIndex = 0, reverseIndex = 0; resIndex < s.length(); resIndex++) {
            if (!chars[resIndex].matches("[a-zA-Z]")) {
                result.append(chars[resIndex]);
            } else {
                result.append(reverseCharsWithoutNumbers[reverseIndex]);
                reverseIndex++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        createCycleToInputStrings(Solution::reverseOnlyLetters);
    }
}

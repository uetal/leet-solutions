package ru.vvikhlyaev.leet.solutions.completed;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * romanToInt
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
class Solution0013 {
    public int romanToInt(String s) {
        String[] numbers = s.split("");
        int res = 0;
        for (int i = 1; i <= numbers.length; i ++) {
            String number = numbers[i-1];
            RomeNumber rn = RomeNumber.getByStr(number);
            if (i != numbers.length) {
                String numberNext = numbers[i];
                RomeNumber rnNext = RomeNumber.getByStr(numberNext);
                if (rnNext.val > rn.val) {
                    res += (rnNext.val - rn.val);
                    i++;
                } else {
                    res += rn.val;
                }
            } else {
                res += rn.val;
            }
        }
        return res;
    }

    private enum RomeNumber {
        I(1, "I"),
        V(5, "V"),
        X(10, "X"),
        L(50, "L"),
        C(100, "C"),
        D(500, "D"),
        M(1000, "M"),
        ;
        private final int val;
        private final String strVal;

        RomeNumber(int val, String strVal) {
            this.val = val;
            this.strVal = strVal;
        }

        private String getStrVal() {
            return strVal;
        }

        private static final Map<String, RomeNumber> map = Arrays.stream(values())
                .collect(Collectors.toMap(RomeNumber::getStrVal, Function.identity()));

        public static RomeNumber getByStr(String s) {
            return map.get(s);
        }
    }

    public static void main(String[] args) {
        test("I", 1);
        test("II", 2);
        test("III", 3);
        test("LVIII", 58);
        test("MCMXCIV", 1994);
    }

    public static void test(String s, int i) {
        Solution0013 sol = new Solution0013();
        int res = sol.romanToInt(s);
        assert res == i;
    }
}

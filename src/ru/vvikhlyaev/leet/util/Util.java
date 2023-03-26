package ru.vvikhlyaev.leet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Util {

    public static boolean testInputStringOutputInt(Function<String, Integer> mapper,
                                                   String input,
                                                   Integer required) {
        return testInputStringOutputInt(mapper, input, required, false);
    }
    public static boolean testInputStringOutputInt(Function<String, Integer> mapper,
                                                   String input,
                                                   Integer required,
                                                   Boolean showDetails) {
        Integer actual = mapper.apply(input);
        boolean isSucceed = actual.equals(required);
        if (showDetails) {
            System.out.printf("%b input = %s required = %d actual = %d \n", isSucceed, input, required, actual);
        } else {
            if (!isSucceed) {
                System.out.printf("%b input = %s required = %d actual = %d \n", isSucceed, input, required, actual);
            } else {
                System.out.println(isSucceed);
            }
        }
        System.out.println("-----------------------------------------------");
        return actual.equals(required);
    }

    public static void createCycleToInputStrings(Function<String, String> mapper) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                System.out.println(mapper.apply(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean testTwoArraysToDouble(BiFunction<int[], int[], Double> mapper,
                                                int[] firstArr,
                                                int[] secondArr,
                                                Double required) {
        var res = mapper.apply(firstArr, secondArr);
        if (res.equals(required)) {
            System.out.println(true);
            return true;
        } else {
            System.out.printf("%b required = %f expected = %f \n", false, required, res);
            return false;
        }
    }
}

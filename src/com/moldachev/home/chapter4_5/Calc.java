package com.moldachev.home.chapter4_5;

import java.util.Arrays;

/**
 * Created by sergey on 25.03.2016.
 */
public class Calc {
    public static int calcSum(boolean evenOnly, Integer... numbers) {
        return Arrays.asList(numbers).stream()
                .filter(num -> num % 2 == 0 || !evenOnly)
                .mapToInt(Integer::intValue).sum();
    }
}

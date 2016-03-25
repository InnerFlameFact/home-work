package com.moldachev.home.chapter4_5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by sergey on 25.03.2016.
 */
public class Calc {
    public static int calcSum(boolean evenOnly, int... numbers) {
        int sum = 0;

        for (int number : numbers) {
            if (evenOnly) {
                if (number % 2 == 0) {
                    sum += number;
                }
            } else {
                sum += number;
            }
        }

        return sum;
    }
}

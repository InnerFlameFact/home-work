package com.moldachev.home.chapter4_5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sergey on 25.03.2016.
 */
public class CalcTest {

    @Test
    public void testCalcSum() throws Exception {
        int sum = Calc.calcSum(true, 1,2,3,5,6,7,8);
        Assert.assertEquals(16, sum);

        sum = Calc.calcSum(false, 1,2,3,4,5,6,7,8);
        Assert.assertEquals(36, sum);

        sum = Calc.calcSum(false, 0,0,3,0,5,0,7,8);
        Assert.assertEquals(23, sum);

        sum = Calc.calcSum(true, -1,-2,3,0,5,0,7,8);
        Assert.assertEquals(6, sum);
    }
}
package com.moldachev.home.chapter6_7.impl;

import com.moldachev.home.chapter6_7.Human;
import com.moldachev.home.chapter6_7.LiveBeingImpl;
import com.moldachev.home.chapter6_7.food.FoodType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public class DefaultHuman extends LiveBeingImpl implements Human {
    @Override
    public Map<FoodType, Integer> acceptableFoodAmount() {
        Map<FoodType, Integer> acceptableFoodAmount = new HashMap<>();
        acceptableFoodAmount.put(FoodType.MEAT, 1);
        acceptableFoodAmount.put(FoodType.VEGETABLES, 2);
        acceptableFoodAmount.put(FoodType.MILK, 2);
        acceptableFoodAmount.put(FoodType.FRUIT, 1);

        return acceptableFoodAmount;
    }
}

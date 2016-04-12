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
    final Map<FoodType, Integer> acceptableFoodAmount = new HashMap<FoodType, Integer>(){
        {
            put(FoodType.MEAT, 1);
            put(FoodType.VEGETABLES, 2);
            put(FoodType.MILK, 2);
            put(FoodType.FRUIT, 1);
        }
    };

    @Override
    public Map<FoodType, Integer> acceptableFoodAmount() {
        return acceptableFoodAmount;
    }
}

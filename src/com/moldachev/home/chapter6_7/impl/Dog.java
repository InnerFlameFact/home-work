package com.moldachev.home.chapter6_7.impl;

import com.moldachev.home.chapter6_7.Animal;
import com.moldachev.home.chapter6_7.LiveBeingImpl;
import com.moldachev.home.chapter6_7.food.FoodType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public class Dog extends LiveBeingImpl implements Animal {

    final Map<FoodType, Integer> acceptableFoodAmount = new HashMap<FoodType, Integer>(){
        {
            put(FoodType.BONE, 1);
            put(FoodType.MEAT, 1);
            put(FoodType.DOG_FOOD, 3);
            put(FoodType.MILK, 2);
        }
    };

    @Override
    public Map<FoodType, Integer> acceptableFoodAmount() {
        return acceptableFoodAmount;
    }
}

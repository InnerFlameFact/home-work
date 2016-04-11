package com.moldachev.home.chapter6_7.impl;

import com.moldachev.home.chapter6_7.Human;
import com.moldachev.home.chapter6_7.LiveBeingImpl;
import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodType;

import java.util.Map;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public class DefaultHuman extends LiveBeingImpl implements Human {
    @Override
    public boolean acceptsFood(Food food) {
        Map<FoodType, Integer> eatingFood = getEatingFood();
        return eatingFood != null && eatingFood.get(food.getType()) != null;
    }
}

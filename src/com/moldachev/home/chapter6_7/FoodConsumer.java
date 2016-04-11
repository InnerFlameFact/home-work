package com.moldachev.home.chapter6_7;

import com.moldachev.home.chapter6_7.food.Food;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public interface FoodConsumer {
    boolean acceptsFood(Food food);
    Food eatNormally(Food food);
}

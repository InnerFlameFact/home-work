package com.moldachev.home.chapter6_7.food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public final class FoodSet {
    protected List<Food> foods;

    public List<Food> getFoods() {
        return foods;
    }

    private FoodSet(List<Food> foods) {
        this.foods = foods;
    }

    public static FoodSet factoryMethod(List<Food> foods) {
        List<Food> newFoods = new ArrayList<>(foods);
        return new FoodSet(newFoods);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FoodSet{");
        sb.append("foods=").append(foods);
        sb.append('}');
        return sb.toString();
    }
}

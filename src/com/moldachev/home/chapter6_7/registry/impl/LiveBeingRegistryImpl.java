package com.moldachev.home.chapter6_7.registry.impl;

import com.moldachev.home.chapter6_7.LiveBeing;
import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodSet;
import com.moldachev.home.chapter6_7.registry.LiveBeingRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public class LiveBeingRegistryImpl<T extends LiveBeing> implements LiveBeingRegistry {
    private List<LiveBeing> registryList;

    public LiveBeingRegistryImpl(T... beings) {
        registryList = Arrays.asList(beings);
    }

    @Override
    public boolean add(LiveBeing... beings) {
        return registryList.addAll(Arrays.asList(beings));
    }

    @Override
    public boolean remove(LiveBeing... beings) {
        return registryList.removeAll(Arrays.asList(beings));
    }

    @Override
    public T findBy(Predicate condition) {
        return null;
    }

    @Override
    public boolean contains(LiveBeing being) {
        return registryList.contains(being);
    }

    @Override
    public FoodSet feedAll(FoodSet originalFood) {
        List<Food> foodList = new ArrayList<>();
        for (LiveBeing entity : registryList) {
            for (Food food : originalFood.getFoods()) {
                foodList.add(entity.eatNormally(food));
            }
        }

        return FoodSet.factoryMethod(foodList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LiveBeingRegistryImpl{");
        sb.append("registryList=").append(registryList);
        sb.append('}');
        return sb.toString();
    }
}

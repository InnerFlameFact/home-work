package com.moldachev.home.chapter6_7.registry.impl;

import com.moldachev.home.chapter6_7.LiveBeing;
import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodSet;
import com.moldachev.home.chapter6_7.registry.LiveBeingRegistry;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public class LiveBeingRegistryImpl<T extends LiveBeing> implements LiveBeingRegistry<T> {
    private List<T> registryList;

    private LiveBeingRegistryImpl(T... beings) {
        registryList = new LinkedList<>(Arrays.asList(beings));
    }

    @Override
    public boolean add(T... beings) {
        return registryList.addAll(Arrays.asList(beings));
    }

    @Override
    public boolean remove(T... beings) {
        return registryList.removeAll(Arrays.asList(beings));
    }

    @Override
    public List<T> findBy(Predicate<T> condition) {
        return registryList.stream().filter(condition).collect(Collectors.<T>toList());
    }

    @Override
    public boolean contains(T being) {
        return registryList.contains(being);
    }

    @Override
    public List<T> getRegistryList() {
        return registryList;
    }

    @Override
    public FoodSet feedAll(FoodSet originalFood) {
        Map<String, Food> foodMap = new HashMap<>();
        for (LiveBeing entity : registryList) {
            for (Food food : originalFood.getFoods()) {
                Food stock = entity.eatNormally(food);
                if (foodMap.get(stock.getName()) != null) {
                    if (foodMap.get(stock.getName()).getQuantity() > stock.getQuantity()) {
                        foodMap.replace(stock.getName(), stock);
                    }
                } else {
                    foodMap.put(stock.getName(), stock);
                }
            }
        }

        return FoodSet.of(foodMap.values().stream().collect(Collectors.toList()));
    }

    public static LiveBeingRegistryImpl<LiveBeing> of(LiveBeing... beings) {
        return new LiveBeingRegistryImpl<>(beings);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("registryList", registryList)
                .toString();
    }
}

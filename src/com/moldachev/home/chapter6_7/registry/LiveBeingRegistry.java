package com.moldachev.home.chapter6_7.registry;

import com.moldachev.home.chapter6_7.LiveBeing;
import com.moldachev.home.chapter6_7.food.FoodSet;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created: 11.04.2016
 *
 * @author sergey
 */
public interface LiveBeingRegistry<T extends LiveBeing> {
    boolean add(T... beings);

    boolean remove(T... beings);

    List<T> findBy(Predicate<T> condition);

    boolean contains(T being);

    FoodSet feedAll(FoodSet originalFood);

    List<T> getRegistryList();
}

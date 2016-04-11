package com.moldachev.home.chapter6_7;

import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodSet;
import com.moldachev.home.chapter6_7.food.FoodType;
import com.moldachev.home.chapter6_7.impl.DefaultHuman;
import com.moldachev.home.chapter6_7.impl.Dog;
import com.moldachev.home.chapter6_7.registry.LiveBeingRegistry;
import com.moldachev.home.chapter6_7.registry.impl.LiveBeingRegistryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergey on 25.03.2016.
 */
public class LiveBeingRegistryImplTest {

    @Test
    public void testLiveBeingRegistryImpl() {
        LiveBeing human = new DefaultHuman();
        LiveBeing dog = new Dog();

        Map<FoodType, Integer> eatingHumanFood = new HashMap<>();
        eatingHumanFood.put(FoodType.HUMAN_FOOD, 2);

        Map<FoodType, Integer> eatingDogFood = new HashMap<>();
        eatingDogFood.put(FoodType.DOG_FOOD, 2);

        human.setName("Sergey");
        human.setBirthDate(LocalDate.of(1994, 8, 19));
        human.setEatingFood(eatingHumanFood);

        dog.setName("Archi");
        dog.setBirthDate(LocalDate.of(2010, 4, 11));
        dog.setEatingFood(eatingDogFood);

        LiveBeingRegistry<LiveBeing> registry = new LiveBeingRegistryImpl<>(human, dog);

        List<Food> foodList = new ArrayList<>();
        foodList.add(Food.factoryMethod(FoodType.DOG_FOOD, "Bone", 20));
        foodList.add(Food.factoryMethod(FoodType.HUMAN_FOOD, "Soup", 10));
        foodList.add(Food.factoryMethod(FoodType.HUMAN_FOOD, "Vegetables", 10));
        foodList.add(Food.factoryMethod(FoodType.DOG_FOOD, "Dog food", 10));

        FoodSet foodSet = FoodSet.factoryMethod(foodList);
        FoodSet stock = registry.feedAll(foodSet);
        System.out.println(stock);
    }
}
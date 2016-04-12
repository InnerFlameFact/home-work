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
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by sergey on 25.03.2016.
 */
public class LiveBeingRegistryImplTest {

    public LiveBeing getDog(){
        LiveBeing dog = new Dog();
        dog.setName("Archi");
        dog.setBirthDate(LocalDate.of(2010, 4, 11));

        return dog;
    }

    public LiveBeing getHuman() {
        LiveBeing human = new DefaultHuman();
        human.setName("Sergey");
        human.setBirthDate(LocalDate.of(1994, 8, 19));

        return human;
    }

    public LiveBeing getAnotherHuman() {
        LiveBeing anotherHuman = new DefaultHuman();
        anotherHuman.setName("Alexandr");
        anotherHuman.setBirthDate(LocalDate.of(1994, 8, 19));

        return anotherHuman;
    }

    public LiveBeingRegistry<LiveBeing> getRegistry(){
        LiveBeing human = getHuman();
        LiveBeing dog = getDog();

        return LiveBeingRegistryImpl.of(human, dog);
    }

    @Test
    public void testFeedAll() {

        LiveBeingRegistry<LiveBeing> registry = getRegistry();

        List<Food> foodList = new ArrayList<>();
        foodList.add(Food.of(FoodType.DOG_FOOD, "Bone", 20));
        foodList.add(Food.of(FoodType.VEGETABLES, "Vegetables", 10));
        foodList.add(Food.of(FoodType.DOG_FOOD, "Dog food", 10));

        FoodSet foodSet = FoodSet.of(foodList);
        FoodSet stock = registry.feedAll(foodSet);

        Assert.assertTrue(stock.getFoods().contains(Food.of(FoodType.DOG_FOOD, "Bone", 17)));
        Assert.assertTrue(stock.getFoods().contains(Food.of(FoodType.VEGETABLES, "Vegetables", 8)));
        Assert.assertTrue(stock.getFoods().contains(Food.of(FoodType.DOG_FOOD, "Dog food", 7)));
    }

    @Test
    public void testRemove() {
        LiveBeing dog = getDog();
        LiveBeing human = getHuman();
        LiveBeingRegistry<LiveBeing> registry = getRegistry();

        Assert.assertTrue(registry.remove(dog,human));
    }

    @Test
    public void testFindBy() {
        LiveBeing human = getHuman();
        LiveBeingRegistry<LiveBeing> registry = getRegistry();
        Predicate<LiveBeing> predicate = p -> p.getName().equals(Optional.of("Sergey"));
        Assert.assertEquals(1, registry.findBy(predicate).size());
        registry.add(human);
        Assert.assertEquals(2, registry.findBy(predicate).size());
    }

    @Test
    public void testContains () {
        LiveBeing dog = getDog();
        LiveBeing human = getHuman();
        LiveBeing anotherHuman = getAnotherHuman();
        LiveBeingRegistry<LiveBeing> registry = getRegistry();

        Assert.assertTrue(registry.contains(dog));
        Assert.assertTrue(registry.contains(human));
        Assert.assertFalse(registry.contains(anotherHuman));
    }

    @Test
    public void testAdd () {
        LiveBeing human = getAnotherHuman();
        LiveBeingRegistry<LiveBeing> registry = getRegistry();
        registry.add(human);
        Assert.assertEquals(3, registry.getRegistryList().size());
    }
}
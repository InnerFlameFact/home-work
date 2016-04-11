package com.moldachev.home.chapter6_7;

import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodType;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public abstract class LiveBeingImpl implements LiveBeing {
    protected LocalDate birthDate;
    protected Optional<LocalDate> deathDate;
    protected Optional<String> name;
    protected Map<FoodType, Integer> eatingFood;

    abstract public boolean acceptsFood(Food food);

    @Override
    public Food eatNormally(Food food) {
        Food stockFood = food;
        if (acceptsFood(food)) {
            // Не знаю, практикуется ли это, но вроде как не должно быть NpE, так как проверили выше с помощью acceptsFood
            Integer eatQuantity = getEatingFood().get(food.getType());
            Integer stockQuantity = (food.getQuantity() - eatQuantity > 0) ? food.getQuantity() - eatQuantity : 0;
            stockFood = Food.factoryMethod(food.getType(), food.getName(), stockQuantity);
            System.out.println("Eating: " + food.getName() + ", stock: " + stockQuantity);
        }

        return stockFood;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Optional<LocalDate> getDeathDate() {
        return deathDate;
    }

    @Override
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = Optional.ofNullable(deathDate);
    }

    @Override
    public Optional<String> getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    @Override
    public Map<FoodType, Integer> getEatingFood() {
        return eatingFood;
    }

    @Override
    public void setEatingFood(Map<FoodType, Integer> eatingFood) {
        this.eatingFood = eatingFood;
    }


}

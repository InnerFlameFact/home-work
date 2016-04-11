package com.moldachev.home.chapter6_7;

import com.moldachev.home.chapter6_7.food.FoodType;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public interface LiveBeing extends FoodConsumer {
    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    Optional<LocalDate> getDeathDate();

    void setDeathDate(LocalDate deathDate);

    Optional<String> getName();

    void setName(String name);

    Map<FoodType, Integer> getEatingFood();

    void setEatingFood(Map<FoodType, Integer> eatingFood);
}

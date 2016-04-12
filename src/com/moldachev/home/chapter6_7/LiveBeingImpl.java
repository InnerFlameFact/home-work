package com.moldachev.home.chapter6_7;

import com.google.common.base.Objects;
import com.moldachev.home.chapter6_7.food.Food;
import com.moldachev.home.chapter6_7.food.FoodType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    @Override
    public boolean acceptsFood(Food food) {
        Map<FoodType, Integer> eatingFood = acceptableFoodAmount();
        return eatingFood != null && eatingFood.get(food.getType()) != null;
    }

    @Override
    public Food eatNormally(Food food) {
        Food stockFood = food;
        if (acceptsFood(food)) {
            Integer eatQuantity = acceptableFoodAmount().get(food.getType());
            Integer stockQuantity = (food.getQuantity() - eatQuantity > 0) ? food.getQuantity() - eatQuantity : 0;
            stockFood = Food.of(food.getType(), food.getName(), stockQuantity);
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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("birthDate", birthDate)
                .append("deathDate", deathDate)
                .append("name", name)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiveBeingImpl liveBeing = (LiveBeingImpl) o;
        return Objects.equal(getBirthDate(), liveBeing.getBirthDate()) &&
                Objects.equal(getDeathDate(), liveBeing.getDeathDate()) &&
                Objects.equal(getName(), liveBeing.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getBirthDate(), getDeathDate(), getName());
    }
}

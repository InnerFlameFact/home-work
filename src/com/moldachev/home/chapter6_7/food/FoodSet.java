package com.moldachev.home.chapter6_7.food;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public final class FoodSet {
    private List<Food> foods;

    public List<Food> getFoods() {
        return ImmutableList.copyOf(foods);
    }

    private FoodSet(List<Food> foods) {
        this.foods = foods;
    }

    public static FoodSet of(List<Food> foods) {
        List<Food> newFoods = new ArrayList<>(foods);
        return new FoodSet(newFoods);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodSet foodSet = (FoodSet) o;
        return Objects.equal(getFoods(), foodSet.getFoods());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFoods());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("foods", foods)
                .toString();
    }
}

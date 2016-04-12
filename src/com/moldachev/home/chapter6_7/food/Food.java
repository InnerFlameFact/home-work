package com.moldachev.home.chapter6_7.food;

import com.google.common.base.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created: 06.04.2016
 *
 * @author sergey
 */
public final class Food {
    private final String name;
    private final int quantity;
    private final FoodType type;

    private Food(FoodType type, String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static Food of(FoodType type, String name, int quantity) {
        return new Food(type, name, quantity);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", name)
                .append("quantity", quantity)
                .append("type", type)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return getQuantity() == food.getQuantity() &&
                Objects.equal(getName(), food.getName()) &&
                getType() == food.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getQuantity(), getType());
    }
}

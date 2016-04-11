package com.moldachev.home.chapter6_7.food;

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

    public static Food factoryMethod(FoodType type, String name, int quantity) {
        return new Food(type, name, quantity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Food{");
        sb.append("name='").append(name).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}

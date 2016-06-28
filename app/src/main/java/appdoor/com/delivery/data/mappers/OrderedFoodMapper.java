package appdoor.com.delivery.data.mappers;


import appdoor.com.delivery.data.orm.tables.OrderedFood;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;

public class OrderedFoodMapper {

    public static OrderedFood mapOrdered(OrderedFoodDomain orderedFood) {
        return new OrderedFood(orderedFood.getFood().getId(), orderedFood.getStatus());
    }

    public static OrderedFoodDomain mapOrdered(OrderedFood orderedFood, FoodItemDomain food) {
        return new OrderedFoodDomain(orderedFood.getId(), food, orderedFood.getStatus());
    }
}

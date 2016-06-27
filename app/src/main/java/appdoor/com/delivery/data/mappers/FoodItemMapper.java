package appdoor.com.delivery.data.mappers;


import appdoor.com.delivery.data.orm.tables.FoodItem;
import appdoor.com.delivery.domain.models.FoodItemDomain;

public class FoodItemMapper {

    public static FoodItem mapFoodItem(FoodItemDomain foodItem) {
        return new FoodItem(foodItem.getId(), foodItem.getTitle(), foodItem.getSubTitle(), foodItem.getDescription(), foodItem.getImage(), foodItem.getCategoryId(), foodItem.getLikes());
    }

    public static FoodItemDomain mapFoodItem(FoodItem foodItem) {
        return new FoodItemDomain(foodItem.getId(), foodItem.getTitle(), foodItem.getSubTitle(), foodItem.getDescription(), foodItem.getImage(), foodItem.getCategoryId(), foodItem.getLikes());
    }
}

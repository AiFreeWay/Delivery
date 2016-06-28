package appdoor.com.delivery.domain.models;


public class OrderedFoodDomain {

    public static final int STATUS_OK = 0;
    public static final int STATUS_WAIT = 1;
    public static final int STATUS_NONE = 2;

    private int id;
    private FoodItemDomain food;
    private int status;

    public OrderedFoodDomain() {
    }

    public OrderedFoodDomain(int id, FoodItemDomain food, int status) {
        this.id = id;
        this.food = food;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodItemDomain getFood() {
        return food;
    }

    public void setFood(FoodItemDomain food) {
        this.food = food;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

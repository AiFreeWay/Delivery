package appdoor.com.delivery.data.orm.tables;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = FoodItem.TABLE_NAME)
public class FoodItem {

    public final static String TABLE_NAME = "foodItem";
    public final static String FIELD_NAME_ID = "id";
    public final static String FIELD_NAME_TITLE = "title";
    public final static String FIELD_NAME_SUBTITLE = "subTitle";
    public final static String FIELD_NAME_DESCRIPTION = "description";
    public final static String FIELD_NAME_IMAGE = "image";
    public final static String FIELD_NAME_CATEGORY_ID = "categoty_id";
    public final static String FIELD_NAME_LIKES = "likes";

    @DatabaseField(id = true, canBeNull = false, dataType = DataType.INTEGER, columnName = FIELD_NAME_ID)
    private int id;
    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = FIELD_NAME_TITLE)
    private String title;
    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = FIELD_NAME_SUBTITLE)
    private String subTitle;
    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = FIELD_NAME_DESCRIPTION)
    private String description;
    @DatabaseField(canBeNull = true, dataType = DataType.STRING, columnName = FIELD_NAME_IMAGE)
    private String image;
    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER, columnName = FIELD_NAME_CATEGORY_ID)
    private int categoryId;
    @DatabaseField(canBeNull = true, dataType = DataType.INTEGER, columnName = FIELD_NAME_LIKES)
    private int likes;

    public FoodItem() {
    }

    public FoodItem(int id, String title, String subTitle, String description, String image, int categoryId, int likes) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

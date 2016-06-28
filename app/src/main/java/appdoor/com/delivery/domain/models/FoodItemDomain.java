package appdoor.com.delivery.domain.models;

import java.io.Serializable;


public class FoodItemDomain implements Serializable {

    private int id;
    private String title;
    private String subTitle;
    private String description;
    private String image;
    private int categoryId;
    private int likes;

    public FoodItemDomain() {
    }

    public FoodItemDomain(int id, String title, String subTitle, String description, String image, int categoryId, int likes) {
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


package appdoor.com.delivery.domain.models;


import java.io.Serializable;

public class MenuItemDomain implements Serializable {

    private int id;
    private String title;
    private String subTitle;
    private String description;
    private String image;

    public MenuItemDomain() {
    }

    public MenuItemDomain(int id, String title, String subTitle, String description, String image) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
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
}

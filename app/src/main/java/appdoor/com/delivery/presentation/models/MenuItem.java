package appdoor.com.delivery.presentation.models;


import appdoor.com.delivery.presentation.utils.FragmentsFactory;

public class MenuItem {

    private int iconRes;
    private int iconSelectedRes;
    private String title;
    private FragmentsFactory.Fragments fragmentsType;

    public MenuItem() {
    }

    public MenuItem(int iconRes, int iconSelectedRes, String title, FragmentsFactory.Fragments fragmentsType) {
        this.iconRes = iconRes;
        this.iconSelectedRes = iconSelectedRes;
        this.title = title;
        this.fragmentsType = fragmentsType;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public int getIconSelectedRes() {
        return iconSelectedRes;
    }

    public void setIconSelectedRes(int iconSelectedRes) {
        this.iconSelectedRes = iconSelectedRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FragmentsFactory.Fragments getFragmentsType() {
        return fragmentsType;
    }

    public void setFragmentsType(FragmentsFactory.Fragments fragmentsType) {
        this.fragmentsType = fragmentsType;
    }
}

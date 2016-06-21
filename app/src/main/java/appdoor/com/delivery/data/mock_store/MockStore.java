package appdoor.com.delivery.data.mock_store;


import java.util.LinkedList;
import java.util.List;

import appdoor.com.delivery.domain.models.MenuCategory;

public class MockStore {

    private List<MenuCategory> mFoodMenu;

    public MockStore() {
        mFoodMenu = new LinkedList<MenuCategory>();
        fillFoodMenu();
    }

    public List<MenuCategory> getFoodMenu() throws Exception {
        return mFoodMenu;
    }

    private void fillFoodMenu() {
        mFoodMenu.add(new MenuCategory(0, "Горячие", "Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg"));
        mFoodMenu.add(new MenuCategory(1, "Закуски", "Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg"));
        mFoodMenu.add(new MenuCategory(2, "Напитки", "Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg"));
        mFoodMenu.add(new MenuCategory(3, "Десерты", "Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg"));
        mFoodMenu.add(new MenuCategory(4, "Роллы", "Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg"));
    }
}

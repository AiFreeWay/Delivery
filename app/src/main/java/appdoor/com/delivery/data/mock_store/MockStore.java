package appdoor.com.delivery.data.mock_store;


import java.util.LinkedList;
import java.util.List;

import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.TableDomain;

public class MockStore {

    private List<MenuItemDomain> mMenu;
    private List<FoodItemDomain> mFoods;

    public MockStore() {
        mMenu = new LinkedList<MenuItemDomain>();
        mFoods = new LinkedList<FoodItemDomain>();
        fillMenu();
        fillFoods();
    }

    public List<MenuItemDomain> getMenu() throws Exception {
        return mMenu;
    }

    public List<FoodItemDomain> getFoods() throws Exception {
        return mFoods;
    }

    public TableDomain getTable(int number) throws Exception {
        TableDomain table = new TableDomain();
        table.setNumber(number);
        table.setStatus(TableDomain.STATUS_OK);
        return table;
    }

    private void fillMenu() {
        mMenu.add(new MenuItemDomain(0, "Горячие", "24","Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg"));
        mMenu.add(new MenuItemDomain(1, "Закуски", "11","Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg"));
        mMenu.add(new MenuItemDomain(2, "Напитки", "13","Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg"));
        mMenu.add(new MenuItemDomain(3, "Десерты", "5","Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg"));
        mMenu.add(new MenuItemDomain(4, "Роллы", "20","Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg"));
    }

    private void fillFoods() {
        mFoods.add(new FoodItemDomain(0, "Горячие", "100","Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg", 0, 0));
        mFoods.add(new FoodItemDomain(1, "Закуски", "150","Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg", 0, 1));
        mFoods.add(new FoodItemDomain(2, "Напитки", "60","Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg", 0, 5));
        mFoods.add(new FoodItemDomain(3, "Десерты", "300","Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg", 0, 0));
        mFoods.add(new FoodItemDomain(4, "Роллы", "220","Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg", 0, 0));mFoods.add(new FoodItemDomain(0, "Горячие", "100","Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg", 0, 0));
        mFoods.add(new FoodItemDomain(5, "Закуски", "150","Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg", 0, 0));
        mFoods.add(new FoodItemDomain(6, "Напитки", "60","Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg", 0, 3));
        mFoods.add(new FoodItemDomain(7, "Десерты", "300","Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg", 0, 0));
        mFoods.add(new FoodItemDomain(8, "Роллы", "220","Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg", 0, 10));
    }
}

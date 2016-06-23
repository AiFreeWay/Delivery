package appdoor.com.delivery.data.mock_store;


import java.util.LinkedList;
import java.util.List;

import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.domain.models.Table;

public class MockStore {

    private List<MenuItem> mMenu;
    private List<FoodItem> mFoods;

    public MockStore() {
        mMenu = new LinkedList<MenuItem>();
        mFoods = new LinkedList<FoodItem>();
        fillMenu();
        fillFoods();
    }

    public List<MenuItem> getMenu() throws Exception {
        return mMenu;
    }

    public List<FoodItem> getFoods() throws Exception {
        return mFoods;
    }

    public Table getTable(int number) throws Exception {
        return new Table(number, Table.STATUS_WAIT);
    }

    private void fillMenu() {
        mMenu.add(new MenuItem(0, "Горячие", "24","Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg"));
        mMenu.add(new MenuItem(1, "Закуски", "11","Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg"));
        mMenu.add(new MenuItem(2, "Напитки", "13","Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg"));
        mMenu.add(new MenuItem(3, "Десерты", "5","Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg"));
        mMenu.add(new MenuItem(4, "Роллы", "20","Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg"));
    }

    private void fillFoods() {
        mFoods.add(new FoodItem(0, "Горячие", "100","Самые вкусные горячие блюда.", "http://img0.liveinternet.ru/images/attach/c/9/126/30/126030942_5281519_frikadelki_iz_svinini164462.jpg"));
        mFoods.add(new FoodItem(1, "Закуски", "150","Закуски для вашего вечера!", "http://god-2016.com/wp-content/uploads/2015/11/appet-trub.jpeg"));
        mFoods.add(new FoodItem(2, "Напитки", "60","Горячие и холодные", "http://img1.liveinternet.ru/images/attach/c/8/99/786/99786055_4524271_1202mon_19.jpg"));
        mFoods.add(new FoodItem(3, "Десерты", "300","Новинка! Фруктовые салаты!", "http://kastrulya.com/images/uploads/4_salat_cezar/gotowall.com20120218_073442_3441.jpg"));
        mFoods.add(new FoodItem(4, "Роллы", "220","Большой выбор холодных и горячих роллов.", "http://xn--80aujbalykg0a2fe.xn--p1ai/storage/editor/img_4934.jpg"));
    }
}

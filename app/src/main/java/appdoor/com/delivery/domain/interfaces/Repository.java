package appdoor.com.delivery.domain.interfaces;


import java.util.List;

import appdoor.com.delivery.domain.models.MenuCategory;

public interface Repository {

    List<MenuCategory> getFoodMenu() throws Exception;
}

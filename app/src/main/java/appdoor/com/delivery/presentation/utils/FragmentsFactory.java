package appdoor.com.delivery.presentation.utils;


import android.os.Bundle;

import java.util.ArrayList;

import appdoor.com.delivery.presentation.views.fragments.AboutFragment;
import appdoor.com.delivery.presentation.views.fragments.BaseFragment;
import appdoor.com.delivery.presentation.views.fragments.EntranceFragment;
import appdoor.com.delivery.presentation.views.fragments.FoodsFragment;
import appdoor.com.delivery.presentation.views.fragments.MenuFragment;
import appdoor.com.delivery.presentation.views.fragments.OrderedFragment;
import appdoor.com.delivery.presentation.views.fragments.ServiceFragment;

public class FragmentsFactory {

    private ArrayList<BaseFragment> mFragmentsLIst;

    public FragmentsFactory() {
        mFragmentsLIst = new ArrayList<BaseFragment>();
        generateFragments();
    }

    private void generateFragments() {
        mFragmentsLIst.add(Fragments.ENTRANCE.id, new EntranceFragment());
        mFragmentsLIst.add(Fragments.MENU.id, new MenuFragment());
        mFragmentsLIst.add(Fragments.SERIVCE.id, new ServiceFragment());
        mFragmentsLIst.add(Fragments.ORDERED.id, new OrderedFragment());
        mFragmentsLIst.add(Fragments.ABOUT.id, new AboutFragment());
        mFragmentsLIst.add(Fragments.ABOUT.id, new AboutFragment());

        for (BaseFragment fragment : mFragmentsLIst) {
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
        }
    }

    public BaseFragment getFragment(Fragments fragmentIndefinder) {
        if (fragmentIndefinder.id == Fragments.FOODS.id) {
            BaseFragment foodFragment = new FoodsFragment();
            foodFragment.setArguments(new Bundle());
            return foodFragment;
        }
        return mFragmentsLIst.get(fragmentIndefinder.id);
    }

    public enum Fragments {
        ENTRANCE(0),
        MENU(1),
        SERIVCE(2),
        ORDERED(3),
        ABOUT(4),
        FOODS(5);

        public int id;
        Fragments(int id) {
            this.id = id;
        }
    }
}

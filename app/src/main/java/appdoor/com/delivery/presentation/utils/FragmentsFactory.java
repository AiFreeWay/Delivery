package appdoor.com.delivery.presentation.utils;


import java.util.ArrayList;

import appdoor.com.delivery.presentation.views.fragments.BaseFragment;
import appdoor.com.delivery.presentation.views.fragments.EntranceFragment;

public class FragmentsFactory {

    private ArrayList<BaseFragment> mFragmentsLIst;

    public FragmentsFactory() {
        mFragmentsLIst = new ArrayList<BaseFragment>();
        generateFragments();
    }

    private void generateFragments() {
        mFragmentsLIst.add(Fragments.ENTRANCE.id, new EntranceFragment());
    }

    public BaseFragment getFragment(Fragments fragmentIndefinder) {
        return mFragmentsLIst.get(fragmentIndefinder.id);
    }

    public enum Fragments {
        ENTRANCE(0);

        int id;
        Fragments(int id) {
            this.id = id;
        }
    }
}

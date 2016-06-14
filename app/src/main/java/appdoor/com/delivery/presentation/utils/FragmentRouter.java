package appdoor.com.delivery.presentation.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentRouter {

    private final String BACK_STACK_TAG;

    private FragmentManager mFragmentManager;
    private int mViewId;

    public FragmentRouter(int viewId, FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        mViewId = viewId;
        BACK_STACK_TAG = viewId+"";
    }

    public void show(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mViewId, fragment);
        transaction.addToBackStack(BACK_STACK_TAG);
        transaction.commit();
    }

    public void back() {
        mFragmentManager.popBackStack();
    }

    public void setViewId(int id) {
        mViewId = id;
    }
}

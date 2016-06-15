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
        if (!isFragmentShowNow(fragment)) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.replace(mViewId, fragment);
            transaction.addToBackStack(BACK_STACK_TAG);
            transaction.commit();
        }
    }

    private boolean isFragmentShowNow(Fragment fragment) {
        Fragment lastFragment = mFragmentManager.findFragmentById(mViewId);
        return lastFragment != null && mFragmentManager.findFragmentById(mViewId).getClass().isInstance(fragment);
    }

    public void back() {
        if (mFragmentManager.getBackStackEntryCount() > 1)
            mFragmentManager.popBackStack();
    }

    public void setViewId(int id) {
        mViewId = id;
    }
}

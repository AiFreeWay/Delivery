package appdoor.com.delivery.presentation.views.activities;


import android.support.v7.app.AppCompatActivity;

import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.components.ActivityComponent;

public abstract class BaseActivity extends AppCompatActivity {

    public DeliveryApplication getDeliveryApplication() {
        return (DeliveryApplication) getApplication();
    }

    public abstract int getFragmentViewId();
    public abstract ActivityComponent getComponent();
}

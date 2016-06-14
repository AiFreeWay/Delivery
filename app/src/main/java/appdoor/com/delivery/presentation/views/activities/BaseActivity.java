package appdoor.com.delivery.presentation.views.activities;


import android.support.v7.app.AppCompatActivity;

import appdoor.com.delivery.presentation.app.DeliveryApplication;

public abstract class BaseActivity extends AppCompatActivity {

    public DeliveryApplication getDeliveryApplication() {
        return (DeliveryApplication) getApplication();
    }
}

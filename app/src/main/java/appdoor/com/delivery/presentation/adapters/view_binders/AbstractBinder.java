package appdoor.com.delivery.presentation.adapters.view_binders;


import android.content.Context;
import android.view.View;

import appdoor.com.delivery.presentation.view_controllers.ViewController;

public interface AbstractBinder<T> {

    public abstract View bind(View view, T data);
}

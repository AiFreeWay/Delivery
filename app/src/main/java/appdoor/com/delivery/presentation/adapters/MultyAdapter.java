package appdoor.com.delivery.presentation.adapters;


import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collections;
import java.util.List;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.adapters.view_binders.AbstractBinder;
import appdoor.com.delivery.presentation.view_controllers.ViewController;

public class MultyAdapter<T> extends BaseAdapter {

    private List<T> mData;
    private AbstractBinder<T> mBinder;

    public MultyAdapter(AbstractBinder<T> binder) {
        mData = Collections.emptyList();
        mBinder = binder;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        T item = getItem(position);
        return mBinder.bind(view, item);
    }

    public void loadData(@Nullable  List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }
}

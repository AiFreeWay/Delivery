package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;

import appdoor.com.delivery.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends BaseFragment {

    @BindView(R.id.fmt_main_et_table)
    EditText mEtTable;
    @BindView(R.id.fmt_main_btn_enter)
    Button mBtnEnter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewAnimator.animate(mEtTable)
                .translationX(-1000, 0)
                //.slideLeft()
                .duration(300)
                .start();
    }
}

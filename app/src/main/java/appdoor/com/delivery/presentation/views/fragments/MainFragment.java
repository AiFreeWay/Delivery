package appdoor.com.delivery.presentation.views.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

import appdoor.com.delivery.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends BaseFragment {

    @BindView(R.id.fmt_main_et_table)
    EditText mEtTable;
    @BindView(R.id.fmt_main_btn_enter)
    Button mBtnEnter;

    private MaterialStyledDialog mDialog;

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
                .dp().translationX(-1000, 0)
                .duration(400)
                .start();

        mDialog = new MaterialStyledDialog(getActivity())
                .setTitle(R.string.thanks)
                .setStyle(Style.HEADER_WITH_TITLE)
                .setDescription(R.string.fmt_main_dialog_description)
                .setPositive(getString(R.string.ok), null)
                .build();

        mBtnEnter.setOnClickListener(v -> {
            mDialog.show();
        });
    }
}

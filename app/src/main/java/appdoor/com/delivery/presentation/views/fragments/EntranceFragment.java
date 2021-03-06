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
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.view_controllers.FragmentEntranceCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;


public class EntranceFragment extends BaseFragment {

    private static final String EMPTY_LINE = "";

    @BindView(R.id.fmt_entrance_et_table)
    EditText mEtTable;
    @BindView(R.id.fmt_entrance_btn_enter)
    Button mBtnEnter;
    @BindView(R.id.fmt_entrance_tv_busy)
    TextView mTvBusy;

    private FragmentEntranceCtrl mViewController;
    private MaterialStyledDialog mDialog;
    private MaterialStyledDialog mErrorDialog;
    private MaterialStyledDialog mExitDialog;

    private View.OnClickListener mEnterListener = v -> {
        if (!mEtTable.getText().toString().isEmpty() && getNumber()>0)
            mDialog.show();

    };

    private View.OnClickListener mCancelListener = v -> {
        mViewController.needCancel();
    };

    private View.OnClickListener mExitListener = v -> {
        mExitDialog.show();
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_entrance, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewController = new FragmentEntranceCtrl(this);
        ViewAnimator.animate(mEtTable)
                .dp().translationX(-1000, 0)
                .duration(400)
                .start();

        mDialog = new MaterialStyledDialog(getActivity())
                .setTitle(R.string.thanks)
                .setStyle(Style.HEADER_WITH_TITLE)
                .setDescription(R.string.fmt_main_dialog_description)
                .setPositive(getString(R.string.ok), (dialog, which) -> mViewController.sendTableNumber(getNumber()))
                .setNegative(getString(R.string.cancel), null)
                .build();

        mErrorDialog = new MaterialStyledDialog(getActivity())
                .setTitle(R.string.sorry)
                .setHeaderColor(R.color.colorOrange)
                .setStyle(Style.HEADER_WITH_TITLE)
                .setDescription(R.string.table_busy)
                .setNeutral(getString(R.string.ok), null)
                .build();

        mExitDialog = new MaterialStyledDialog(getActivity())
                .setTitle(R.string.exit)
                .setHeaderColor(R.color.colorOrange)
                .setStyle(Style.HEADER_WITH_TITLE)
                .setDescription(R.string.realy_exit)
                .setPositive(getString(R.string.ok), (dialog, which) -> mViewController.release())
                .setNegative(getString(R.string.order_cancel), null)
                .build();

        mBtnEnter.setOnClickListener(mEnterListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewController.start();
    }

    private int getNumber() {
        return Integer.parseInt(mEtTable.getText().toString());
    }

    public void showErrorDialog() {
        mErrorDialog.show();
    }

    public void setStatusNone() {
        mEtTable.setText(EMPTY_LINE);
        mTvBusy.setVisibility(View.INVISIBLE);
        unlockEditText();

        mBtnEnter.setText(R.string.enter);
        mBtnEnter.setBackground(getResources().getDrawable(R.drawable.login_button));
        mBtnEnter.setOnClickListener(mEnterListener);
    }

    public void setStatusOk(int number) {
        mEtTable.setText(number+EMPTY_LINE);
        mTvBusy.setVisibility(View.INVISIBLE);
        lockEditText();

        mBtnEnter.setText(R.string.exit);
        mBtnEnter.setBackground(getResources().getDrawable(R.drawable.login_button_cancel));
        mBtnEnter.setOnClickListener(mExitListener);
    }

    public void setStatusWait(int number) {
        mEtTable.setText(number+EMPTY_LINE);
        mTvBusy.setVisibility(View.VISIBLE);
        lockEditText();

        mBtnEnter.setText(R.string.order_cancel);
        mBtnEnter.setBackground(getResources().getDrawable(R.drawable.login_button_cancel));
        mBtnEnter.setOnClickListener(mCancelListener);
    }

    public void setStatusBusy() {
        setStatusNone();
        showErrorDialog();
    }

    private void lockEditText() {
        mEtTable.setFocusable(false);
        mEtTable.setFocusableInTouchMode(false);
        mEtTable.setClickable(false);
    }

    private void unlockEditText() {
        mEtTable.setFocusable(true);
        mEtTable.setFocusableInTouchMode(true);
        mEtTable.setClickable(true);
    }
}

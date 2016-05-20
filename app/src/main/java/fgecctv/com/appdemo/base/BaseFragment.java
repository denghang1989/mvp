package fgecctv.com.appdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/20 10
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity       mActivity;
    protected Unbinder           mUnbinder;
    protected InputMethodManager mIMM;
    protected boolean            mNeedHideSoft;
    protected BasePresent        mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        } else {
            throw new ClassCastException(context.toString() + "必须继承BaseActivity");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMM = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        mPresenter = getPresent();
    }

    protected abstract BasePresent getPresent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mNeedHideSoft) {
            hideKeyboard();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    /**
     * @return
     */
    public BaseActivity getHoldingActivity() {
        return mActivity;
    }

    protected abstract int getLayoutId();

    /*显示键盘*/
    public void hideKeyboard() {
        if (getView() != null) {
            mIMM.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    /*隐藏键盘*/
    public void showKeyboard(final View view) {
        if (view == null) {
            return;
        }
        view.requestFocus();
        mNeedHideSoft = true;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIMM.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
            }
        }, 200);
    }

}
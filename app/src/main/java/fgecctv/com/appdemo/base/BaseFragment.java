package fgecctv.com.appdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import io.realm.Realm;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/20 10
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity       mActivity;
    private   InputMethodManager mIMM;
    private   boolean            mNeedHideSoft;
    private   BasePresent        mPresenter;
    protected Realm              mRealm;
    private   LoadingPager       mLoadingPager;
    private static final String TAG = "BaseFragment";

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
        mRealm = Realm.getDefaultInstance();
        mPresenter = getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLoadingPager == null) {
            mLoadingPager = new LoadingPager(mActivity) {

                @Override
                public int getLayoutId() {
                    return BaseFragment.this.getLayoutId();
                }

                @Override
                public void initLoadData() {
                    mPresenter.subscribe();
                }
            };
        }
        return mLoadingPager;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLoadingPager.triggerLoadData();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mNeedHideSoft) {
            hideKeyboard();
        }
        mPresenter.unsubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    protected abstract BasePresent getPresenter();

    /**
     * @return
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    protected abstract int getLayoutId();

    /*显示键盘*/
    private void hideKeyboard() {
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

    public LoadingPager getLoadingPager() {
        return mLoadingPager;
    }

    /**
     * @dec: oncreateView之后的生命周期才能调用
     */
    public View getSuccessView() {
        return mLoadingPager.getSuccessView();
    }
}

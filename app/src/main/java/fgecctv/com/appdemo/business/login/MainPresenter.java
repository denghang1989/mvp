package fgecctv.com.appdemo.business.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import fgecctv.com.appdemo.base.libpresenter.Presenter;
import fgecctv.com.appdemo.model.DataManager;
import fgecctv.com.appdemo.model.data.pojo.LoginResponse;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.business.login
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/6/15 10
 */
public class MainPresenter extends Presenter<IMainView> {

    private static final String TAG = "MainPresenter";
    private DataManager           mDataManager;
    private CompositeSubscription mSubscription;

    public MainPresenter(DataManager manager) {
        mDataManager = manager;
        mSubscription = new CompositeSubscription();
    }

    @Override
    protected void onTakeView(IMainView view) {
        super.onTakeView(view);
        Log.d(TAG, "onTakeView: ");
    }

    @Override
    protected void onLoad(@Nullable Bundle savedInstanceState, boolean reusing) {
        super.onLoad(savedInstanceState, reusing);
        Log.d(TAG, "onLoad: ");
        getView().setTitle("登入");
        updateLoadingShown();
    }

    public void onSignInClicked() {
        String account = getView().getAccount();
        String password = getView().getPassword();
        mSubscription.clear();
        Subscription subscribe = mDataManager.login(account, password).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().handleSignInException(e);
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        getView().handleSignInSuccess();
                    }
                });
        mSubscription.add(subscribe);
    }

    public void onSignUpClicked() {
        mSubscription.clear();
    }

    private void updateLoadingShown() {
        if (!hasView()) {
            return;
        }
        if (mSubscription.hasSubscriptions()) {
            getView().showLoading();
        } else {
            getView().hideLoading();
        }
        if (mSubscription.hasSubscriptions()) {
            getView().disableSignIn();
        } else {
            getView().enableSignIn();
        }
    }

}

package fgecctv.com.appdemo.ui.mvp.presenter;

import android.support.annotation.NonNull;

import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.UserContract;
import rx.subscriptions.CompositeSubscription;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.mvp.presenter
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/24 17
 */
public class UserPresenter implements UserContract.Presenter {
    private DataManager mDataManager;
    private UserContract.View mView;
    private CompositeSubscription mSubscription;

    public UserPresenter(@NonNull DataManager dataManager,@NonNull UserContract.View view) {
        mDataManager = dataManager;
        mView = view;
        mSubscription = new CompositeSubscription();
    }

    @Override
    public void modifyAvatar() {

    }

    @Override
    public void modifyAccount() {

    }

    @Override
    public void modefyNickname() {

    }

    @Override
    public void modefySex() {

    }

    @Override
    public void modefyAddress() {

    }

    @Override
    public void subscribe() {
        mSubscription.clear();
    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
        mSubscription.unsubscribe();
    }
}

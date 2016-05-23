package fgecctv.com.appdemo.ui.mvp.presenter;

import android.support.annotation.NonNull;

import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.HomeContract;
import rx.subscriptions.CompositeSubscription;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.mvp.presenter
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/22 15
 */
public class HomePresenter implements HomeContract.Presenter {
    private DataManager mManager;
    private HomeContract.View mView;
    private CompositeSubscription mSubscription;

    public HomePresenter(@NonNull DataManager manager,@NonNull HomeContract.View view) {
        mManager = manager;
        mView = view;
        mSubscription = new CompositeSubscription();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
        mSubscription.unsubscribe();
    }
}

package fgecctv.com.appdemo.ui.mvp.presenter;

import android.support.annotation.NonNull;

import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.MainContract;
import rx.subscriptions.CompositeSubscription;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.mvp.presenter
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 16
 */
public class MainPresenter implements MainContract.Presenter {
    private CompositeSubscription mSubscriptions;
    private MainContract.View     mView;
    private DataManager           mDataManager;
    private boolean               isFirstLoad;

    public MainPresenter(@NonNull DataManager dataManager, @NonNull MainContract.View view) {
        mSubscriptions = new CompositeSubscription();
        mView = view;
        mDataManager = dataManager;
        mView.setPresent(this);
    }

    @Override
    public void subscribe() {
        loadData(isFirstLoad);
    }

    /*@Override
    public void loadData() {
        mSubscriptions.clear();
        Subscription subscription = mDataManager.getWeather(mView.getCity()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Weather>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Weather weather) {

                    }
                });
        mSubscriptions.add(subscription);
    }*/

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void loadData(boolean load) {

    }
}

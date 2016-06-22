package fgecctv.com.appdemo.model.local;

import fgecctv.com.appdemo.model.local.daoservice.UserService;
import fgecctv.com.appdemo.model.data.entity.User;
import rx.Observable;
import rx.Subscriber;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local
 * @Description:
 * @date 2016/5/5 15
 */
public class DatabaseHelper {

    private static DatabaseHelper mDatabaseHelper;

    private DatabaseHelper() {
    }

    public static DatabaseHelper getInstance() {
        if (mDatabaseHelper != null) {
            synchronized (DatabaseHelper.class) {
                if (mDatabaseHelper != null) {
                    mDatabaseHelper = new DatabaseHelper();
                }
            }
        }
        return mDatabaseHelper;
    }

    public Observable<User> findAllUser() {
        return Observable.from(UserService.findAllUser());
    }

    public Observable<User> findUserByName(String name) {
        return Observable.just(UserService.findUserByName(name));
    }

    public Observable<User> findUserById(final int id) {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                subscriber.onNext(UserService.findUserById(id));
                subscriber.onCompleted();
            }
        });
    }

}

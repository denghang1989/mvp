package fgecctv.com.appdemo.data.local;

import fgecctv.com.appdemo.data.local.daoImpl.UserImpl;
import fgecctv.com.appdemo.data.model.bean.User;
import io.realm.Realm;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local
 * @Description:
 * @date 2016/5/5 15
 */
public class DatabaseHelper {

    private static DatabaseHelper mDatabaseHelper;
    private Realm mRealm;

    private DatabaseHelper(Realm realm) {
        mRealm = realm;
    }

    public static DatabaseHelper getInstance(Realm realm) {
        if (mDatabaseHelper == null) {
            synchronized (DatabaseHelper.class) {
                if (mDatabaseHelper == null) {
                    mDatabaseHelper = new DatabaseHelper(realm);
                }
            }
        }
        return mDatabaseHelper;
    }

    public Observable<User> getUserInfo() {
        return UserImpl.getInstance().find(mRealm);
    }

    public Observable<User> getUserInfoByName(String name) {
        return UserImpl.getInstance().find(mRealm,name);
    }

    public void saveUserInfo( User user) {
        UserImpl.getInstance().update(mRealm,user);
    }

}

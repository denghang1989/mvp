package fgecctv.com.appdemo.data.local.daoImple;

import fgecctv.com.appdemo.data.local.dao.UserDao;
import fgecctv.com.appdemo.data.model.bean.User;
import io.realm.Realm;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local.dao
 * @Description: (demo 演示realm)
 * @date 2016/5/5 16
 */
public class UserImpl implements UserDao {

    private UserImpl() {
    }

    private static UserImpl userImpli;

    public static UserImpl getInstance() {
        if (userImpli == null) {
            synchronized (UserImpl.class) {
                if (userImpli == null) {
                    userImpli = new UserImpl();
                }
            }
        }
        return userImpli;
    }

    @Override
    public Observable<User> find(Realm realm) {
        return realm.where(User.class).findFirst().asObservable();
    }

    @Override
    public Observable<User> find(Realm realm, String name) {
        return realm.where(User.class).equalTo("name", name).findFirst().asObservable();
    }

    @Override
    public void update(Realm realm, User user) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    @Override
    public void insert(Realm realm, User user) {
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    @Override
    public void delete(Realm realm, User user) {
        realm.beginTransaction();
        user.deleteFromRealm();
        realm.commitTransaction();
    }
}

package fgecctv.com.appdemo.data.local.dao;

import fgecctv.com.appdemo.data.model.bean.User;
import io.realm.Realm;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local.daoimple
 * @Description: (realm 演示demo)
 * @date 2016/5/9 16
 */
public interface UserDao {
    Observable<User> find(Realm realm);

    Observable<User> find(Realm realm, String name);

    void update(Realm realm, User user);

    void insert(Realm realm, User user);

    void delete(Realm realm, User user);
}

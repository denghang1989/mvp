package fgecctv.com.appdemo.data.local;

import fgecctv.com.appdemo.data.local.dao.Dao;
import fgecctv.com.appdemo.data.local.daoImple.UserImpl;
import fgecctv.com.appdemo.data.model.table.User;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local
 * @Description: (多个工厂方法模式)
 * @date 2016/5/5 15
 */
public class DatabaseHelper {

    private static DatabaseHelper mDatabaseHelper;

    private DatabaseHelper() {
    }

    public static DatabaseHelper getInstance() {
        if (mDatabaseHelper == null) {
            synchronized (DatabaseHelper.class) {
                if (mDatabaseHelper == null) {
                    mDatabaseHelper = new DatabaseHelper();
                }
            }
        }
        return mDatabaseHelper;
    }

    public Dao<User> getUser() {
        return UserImpl.getInstance();
    }

}

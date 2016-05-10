package fgecctv.com.appdemo.data.local;

import fgecctv.com.appdemo.data.local.dao.UserDao;
import fgecctv.com.appdemo.data.local.daoImple.UserImple;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local
 * @Description: (表的操作类)
 * @date 2016/5/5 15
 */
public class DatabaseHelper {

    private static UserImple mUserImple;

    public static UserDao newInstance() {
        if (mUserImple == null) {
            synchronized (DatabaseHelper.class) {
                if (mUserImple == null) {
                    mUserImple = new UserImple();
                }
            }
        }
        return mUserImple;
    }

}

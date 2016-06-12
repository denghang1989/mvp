package fgecctv.com.appdemo.data.local.daoImpl;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local.dao
 * @Description: (demo 演示realm)
 * @date 2016/5/5 16
 */
public class UserImpl {

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


}

package fgecctv.com.appdemo.model.local.daoservice;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fgecctv.com.appdemo.model.data.entity.User;
import fgecctv.com.appdemo.model.data.entity.User_Table;

/**
 * @author denghang
 * @version V1.0
 * @date 2016/5/5 16
 */
public class UserService {

    public static List<User> findAllUser() {
        List<User> users = SQLite.select().from(User.class).queryList();
        return users;
    }

    public static User findUserByName(String name) {
        User user = SQLite.select().from(User.class).where(User_Table.name.eq(name)).querySingle();
        return user;
    }

    public static void deletAllUser() {
        SQLite.delete().from(User.class).execute();
    }

    public static void deleteUserByName(String name) {
        SQLite.delete().from(User.class).where(User_Table.name.eq(name)).execute();
    }

    public static void updateUser(User user) {
        user.update();
    }

    public static void insertUser(User user) {
        user.insert();
    }

    public static void saveUser(User user) {
        user.save();
    }

}

package fgecctv.com.appdemo.data.local;

import fgecctv.com.appdemo.data.local.daoImpl.WeatherImpl;

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

<<<<<<< 04d46aaf230b1537ed4472b7c02b114e42f33f16
    public WeatherImple getWeatherService() {
        return WeatherImple.getWeatherImple();
=======
    public WeatherImpl getWeatherService() {
        return WeatherImpl.getWeatherImple();
>>>>>>> 谁便写点东西
    }

}

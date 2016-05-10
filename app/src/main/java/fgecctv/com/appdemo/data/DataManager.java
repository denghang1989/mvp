package fgecctv.com.appdemo.data;


/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data
 * @Description: 单例（数据供应商）
 * @date 2016/5/5 10
 */
public class DataManager {

    private static DataManager dataManager ;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            synchronized (DataManager.class) {
                if (dataManager == null) {
                    dataManager = new DataManager();
                }
            }
        }
        return dataManager;
    }
}

package fgecctv.com.appdemo.base;

import android.support.annotation.NonNull;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (mvp 约束接口)
 * @date 2016/5/6 15
 */
public interface BaseView<T> {
    void setPresent(@NonNull T present);
}

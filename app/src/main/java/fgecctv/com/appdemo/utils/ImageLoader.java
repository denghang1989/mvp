package fgecctv.com.appdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.utils
 * @Description: (图片框架的封装)
 * @date 2016/5/14 09
 */
public class ImageLoader {

    /**
     * @param context
     * @param url
     * @param view
     */
    public static void display(Context context, String url, ImageView view) {
        Glide.with(context).load(url).into(view);
    }
}

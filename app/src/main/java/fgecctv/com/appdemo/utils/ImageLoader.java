package fgecctv.com.appdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import fgecctv.com.appdemo.R;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.utils
 * @Description: (图片框架的封装, 防止图片框架的切换)
 * @date 2016/5/14 09
 */
public class ImageLoader {

    /**
     * @param context
     * @param url
     * @param view
     */
    public static void display(Context context, String url, ImageView view) {
        Glide.with(context).load(url).centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).crossFade().into(view);
    }

    /**
     * @param activity
     * @param url
     * @param view
     * @desc 绑定activity的生命周期
     */
    public static void display(Activity activity, String url, ImageView view) {
        Glide.with(activity).load(url).centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).crossFade().into(view);
    }

    /**
     * @param fragment
     * @param url
     * @param view
     * @desc 绑定fragment的生命周期
     */
    public static void display(Fragment fragment, String url, ImageView view) {
        Glide.with(fragment).load(url).centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).crossFade().into(view);
    }

}

package fgecctv.com.appdemo.data.remote;

import android.content.Context;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.remote
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/5 11
 */
public class RetrofitService {

    private static final String BASE_URL = "http://120.24.181.136/cloud/";
    private static APIService.WeatherService weatherService;

    private static Retrofit createRetrofit(Context context) {
        Gson gson = new GsonBuilder().
                setDateFormat("yyyy-MM-dd HH:mm:ss").
                setExclusionStrategies(new MyExclusionStrategy()).
                create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpHelper.createClient(context))
                .build();
    }

    public static APIService.WeatherService getWeatherService(Context context) {
        if (weatherService == null) {
            synchronized (RetrofitService.class) {
                if (weatherService == null) {
                    weatherService = createRetrofit(context).create(APIService.WeatherService.class);
                }
            }
        }
        return weatherService;
    }


    /**
     * 配置table对象的实例化，对象的实例化需要手动存储一下
     */
    static class MyExclusionStrategy implements ExclusionStrategy {

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getDeclaringClass().equals(RealmObject.class);
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }
}

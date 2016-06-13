package fgecctv.com.appdemo.model.remote;

import fgecctv.com.appdemo.model.data.pojo.FourDayWeather;
import fgecctv.com.appdemo.model.data.pojo.LoginResponse;
import fgecctv.com.appdemo.model.data.pojo.WeatherDataBean;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.remote
 * @Description: (api 集合)
 * @date 2016/5/5 11
 */
public interface APIService {

    /**
     * 天气的service
     */
    // 百度天气api 获取天气 手动解析
    @Headers("apikey:cec4e963be2a3073785eeaa9c3aa237f")
    @GET("http://apis.baidu.com/apistore/weatherservice/weather")
    Observable<Result<WeatherDataBean>> getWeatherByCity(@Query("citypinyin") String citypinyin);

    /*百度未来4天天气的api*/
    @Headers("apikey:cec4e963be2a3073785eeaa9c3aa237f")
    @GET("http://apis.baidu.com/apistore/weatherservice/recentweathers")
    Observable<Result<FourDayWeather>> get4dayWeatherDataByCity(@Query("cityname") String city);

    /*登入*/
    @FormUrlEncoded
    @POST("http://apis.baidu.com/apistore/weatherservice/recentweathers")
    Observable<Result<LoginResponse>> login(@Field("useid") String useid, @Field("passward") String passward);
}

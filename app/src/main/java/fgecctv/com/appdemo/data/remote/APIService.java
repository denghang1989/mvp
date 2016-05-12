package fgecctv.com.appdemo.data.remote;

import fgecctv.com.appdemo.data.model.pojo.FourDayWeather;
import fgecctv.com.appdemo.data.model.pojo.WeatherDataBean;
import retrofit2.http.GET;
import retrofit2.http.Headers;
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
    Observable<WeatherDataBean> getWeatherByCity(@Query("citypinyin") String citypinyin);

    /*百度未来4天天气的api*/
    @Headers("apikey:cec4e963be2a3073785eeaa9c3aa237f")
    @GET("http://apis.baidu.com/apistore/weatherservice/recentweathers")
    Observable<FourDayWeather> get4dayWeatherDataByCity(@Query("cityname") String city);


}

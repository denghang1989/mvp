package fgecctv.com.appdemo.data.model.bean;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.model.bean
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 12
 */
public class Weather extends BaseData {
    private String city;
    private String weather;
    private String temp;
    private String l_tmp; // 最低温度
    private String h_tmp; // 最高温度
    private String pm25;
    private String humiture; // 温湿度

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getL_tmp() {
        return l_tmp;
    }

    public void setL_tmp(String l_tmp) {
        this.l_tmp = l_tmp;
    }

    public String getH_tmp() {
        return h_tmp;
    }

    public void setH_tmp(String h_tmp) {
        this.h_tmp = h_tmp;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getHumiture() {
        return humiture;
    }

    public void setHumiture(String humiture) {
        this.humiture = humiture;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", l_tmp='" + l_tmp + '\'' +
                ", h_tmp='" + h_tmp + '\'' +
                ", pm25='" + pm25 + '\'' +
                '}';
    }
}

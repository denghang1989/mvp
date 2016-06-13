package fgecctv.com.appdemo.model.data.pojo;

import java.util.List;

/**
 * @author denghang
 * @version V1.0
 * @Package com.magic.ui.weatheractivity
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/4/5 15
 */
public class FourDayWeather {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"city":"北京","cityid":"101010100","today":{"date":"2016-04-05","week":"星期二","curTemp":"21℃","aqi":"217","fengxiang":"南风","fengli":"3-4级","hightemp":"24℃","lowtemp":"11℃","type":"晴","index":[{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","index":"较舒适","name":"穿衣指数","otherName":""},{"code":"yd","details":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。","index":"较适宜","name":"运动指数","otherName":""},{"code":"xc","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","index":"较适宜","name":"洗车指数","otherName":""},{"code":"ls","details":"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！","index":"适宜","name":"晾晒指数","otherName":""}]},"forecast":[{"date":"2016-04-06","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"23℃","lowtemp":"12℃","type":"霾"},{"date":"2016-04-07","week":"星期四","fengxiang":"北风","fengli":"3-4级","hightemp":"23℃","lowtemp":"8℃","type":"晴"},{"date":"2016-04-08","week":"星期五","fengxiang":"南风","fengli":"3-4级","hightemp":"24℃","lowtemp":"11℃","type":"晴"},{"date":"2016-04-09","week":"星期六","fengxiang":"无持续风向","fengli":"微风级","hightemp":"26℃","lowtemp":"12℃","type":"晴"}],"history":[{"date":"2016-03-29","week":"星期二","aqi":"66","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"7℃","type":"晴"},{"date":"2016-03-30","week":"星期三","aqi":"77","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"7℃","type":"晴"},{"date":"2016-03-31","week":"星期四","aqi":"250","fengxiang":"南风","fengli":"3-4级","hightemp":"23℃","lowtemp":"13℃","type":"晴"},{"date":"2016-04-01","week":"星期五","aqi":"47","fengxiang":"北风","fengli":"3-4级","hightemp":"23℃","lowtemp":"11℃","type":"晴"},{"date":"2016-04-02","week":"星期六","aqi":"43","fengxiang":"北风","fengli":"3-4级","hightemp":"18℃","lowtemp":"8℃","type":"多云"},{"date":"2016-04-03","week":"星期天","aqi":"59","fengxiang":"无持续风向","fengli":"微风级","hightemp":"19℃","lowtemp":"6℃","type":"晴"},{"date":"2016-04-04","week":"星期一","aqi":"104","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"8℃","type":"晴"}]}
     */

    private int errNum;
    private String errMsg;
    /**
     * city : 北京
     * cityid : 101010100
     * today : {"date":"2016-04-05","week":"星期二","curTemp":"21℃","aqi":"217","fengxiang":"南风","fengli":"3-4级","hightemp":"24℃","lowtemp":"11℃","type":"晴","index":[{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","index":"较舒适","name":"穿衣指数","otherName":""},{"code":"yd","details":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。","index":"较适宜","name":"运动指数","otherName":""},{"code":"xc","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","index":"较适宜","name":"洗车指数","otherName":""},{"code":"ls","details":"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！","index":"适宜","name":"晾晒指数","otherName":""}]}
     * forecast : [{"date":"2016-04-06","week":"星期三","fengxiang":"无持续风向","fengli":"微风级","hightemp":"23℃","lowtemp":"12℃","type":"霾"},{"date":"2016-04-07","week":"星期四","fengxiang":"北风","fengli":"3-4级","hightemp":"23℃","lowtemp":"8℃","type":"晴"},{"date":"2016-04-08","week":"星期五","fengxiang":"南风","fengli":"3-4级","hightemp":"24℃","lowtemp":"11℃","type":"晴"},{"date":"2016-04-09","week":"星期六","fengxiang":"无持续风向","fengli":"微风级","hightemp":"26℃","lowtemp":"12℃","type":"晴"}]
     * history : [{"date":"2016-03-29","week":"星期二","aqi":"66","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"7℃","type":"晴"},{"date":"2016-03-30","week":"星期三","aqi":"77","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"7℃","type":"晴"},{"date":"2016-03-31","week":"星期四","aqi":"250","fengxiang":"南风","fengli":"3-4级","hightemp":"23℃","lowtemp":"13℃","type":"晴"},{"date":"2016-04-01","week":"星期五","aqi":"47","fengxiang":"北风","fengli":"3-4级","hightemp":"23℃","lowtemp":"11℃","type":"晴"},{"date":"2016-04-02","week":"星期六","aqi":"43","fengxiang":"北风","fengli":"3-4级","hightemp":"18℃","lowtemp":"8℃","type":"多云"},{"date":"2016-04-03","week":"星期天","aqi":"59","fengxiang":"无持续风向","fengli":"微风级","hightemp":"19℃","lowtemp":"6℃","type":"晴"},{"date":"2016-04-04","week":"星期一","aqi":"104","fengxiang":"无持续风向","fengli":"微风级","hightemp":"22℃","lowtemp":"8℃","type":"晴"}]
     */

    private RetDataEntity retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public static class RetDataEntity {
        private String city;
        private String cityid;
        /**
         * date : 2016-04-05
         * week : 星期二
         * curTemp : 21℃
         * aqi : 217
         * fengxiang : 南风
         * fengli : 3-4级
         * hightemp : 24℃
         * lowtemp : 11℃
         * type : 晴
         * index : [{"name":"感冒指数","code":"gm","index":"","details":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","otherName":""},{"code":"fs","details":"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。","index":"中等","name":"防晒指数","otherName":""},{"code":"ct","details":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","index":"较舒适","name":"穿衣指数","otherName":""},{"code":"yd","details":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。","index":"较适宜","name":"运动指数","otherName":""},{"code":"xc","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","index":"较适宜","name":"洗车指数","otherName":""},{"code":"ls","details":"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！","index":"适宜","name":"晾晒指数","otherName":""}]
         */

        private TodayEntity today;
        /**
         * date : 2016-04-06
         * week : 星期三
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 23℃
         * lowtemp : 12℃
         * type : 霾
         */

        private List<ForecastEntity> forecast;
        /**
         * date : 2016-03-29
         * week : 星期二
         * aqi : 66
         * fengxiang : 无持续风向
         * fengli : 微风级
         * hightemp : 22℃
         * lowtemp : 7℃
         * type : 晴
         */

        private List<HistoryEntity> history;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setToday(TodayEntity today) {
            this.today = today;
        }

        public void setForecast(List<ForecastEntity> forecast) {
            this.forecast = forecast;
        }

        public void setHistory(List<HistoryEntity> history) {
            this.history = history;
        }

        public String getCity() {
            return city;
        }

        public String getCityid() {
            return cityid;
        }

        public TodayEntity getToday() {
            return today;
        }

        public List<ForecastEntity> getForecast() {
            return forecast;
        }

        public List<HistoryEntity> getHistory() {
            return history;
        }

        public static class TodayEntity {
            private String date;
            private String week;
            private String curTemp;
            private String aqi;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;
            /**
             * name : 感冒指数
             * code : gm
             * index :
             * details : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
             * otherName :
             */

            private List<IndexEntity> index;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setCurTemp(String curTemp) {
                this.curTemp = curTemp;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setIndex(List<IndexEntity> index) {
                this.index = index;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getCurTemp() {
                return curTemp;
            }

            public String getAqi() {
                return aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }

            public List<IndexEntity> getIndex() {
                return index;
            }

            public static class IndexEntity {
                private String name;
                private String code;
                private String index;
                private String details;
                private String otherName;

                public void setName(String name) {
                    this.name = name;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public void setOtherName(String otherName) {
                    this.otherName = otherName;
                }

                public String getName() {
                    return name;
                }

                public String getCode() {
                    return code;
                }

                public String getIndex() {
                    return index;
                }

                public String getDetails() {
                    return details;
                }

                public String getOtherName() {
                    return otherName;
                }
            }
        }

        public static class ForecastEntity {
            private String date;
            private String week;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }
        }

        public static class HistoryEntity {
            private String date;
            private String week;
            private String aqi;
            private String fengxiang;
            private String fengli;
            private String hightemp;
            private String lowtemp;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setHightemp(String hightemp) {
                this.hightemp = hightemp;
            }

            public void setLowtemp(String lowtemp) {
                this.lowtemp = lowtemp;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getWeek() {
                return week;
            }

            public String getAqi() {
                return aqi;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public String getHightemp() {
                return hightemp;
            }

            public String getLowtemp() {
                return lowtemp;
            }

            public String getType() {
                return type;
            }
        }
    }
}

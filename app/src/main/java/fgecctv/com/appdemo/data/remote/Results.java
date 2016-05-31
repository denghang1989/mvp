package fgecctv.com.appdemo.data.remote;

import java.util.List;

import retrofit2.adapter.rxjava.Result;
import rx.functions.Func1;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.remote
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/31 17
 */
public class Results {

    public static Func1<Result<?>, Boolean> request_func = new Func1<Result<?>, Boolean>() {
        @Override
        public Boolean call(Result<?> result) {
            return result.response().isSuccessful();
        }
    };

    public static Func1<Result<?>, Boolean> isSuccess() {
        return request_func;
    }

    public static Func1<List<?>, Boolean> data_func = new Func1<List<?>, Boolean>() {
        @Override
        public Boolean call(List<?> list) {
            return list != null && list.size() > 0;
        }
    };

    public static Func1<List<?>, Boolean> isNotNull() {
        return data_func;
    }

}

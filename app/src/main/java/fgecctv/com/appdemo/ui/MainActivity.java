package fgecctv.com.appdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.data.model.pojo.WeatherDataBean;
import fgecctv.com.appdemo.data.remote.RetrofitService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHello = (TextView) findViewById(R.id.hello);

        RetrofitService.getWeatherService(getApplicationContext())
                .getWeatherByCity("beijing")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherDataBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(WeatherDataBean weatherDataBean) {
                        Log.d(TAG, "onNext: "+weatherDataBean.getErrNum());
                    }
                });
    }
}

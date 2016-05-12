package fgecctv.com.appdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fgecctv.com.appdemo.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHello = (TextView) findViewById(R.id.hello);

    }
}

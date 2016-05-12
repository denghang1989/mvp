package fgecctv.com.appdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.ui.recyclerview.CommonAdapter;
import fgecctv.com.appdemo.ui.recyclerview.DividerItemDecoration;
import fgecctv.com.appdemo.ui.recyclerview.OnRecyclerItemClickListener;
import fgecctv.com.appdemo.ui.recyclerview.ViewHolder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mListView;
    private List<String> mList = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (RecyclerView) findViewById(R.id.listView);
        mListView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.HORIZONTAL_LIST));
        CommonAdapter<String> adapter = new CommonAdapter<String>(getApplicationContext(), R.layout.item, mList) {

            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.textView, s);
            }
        };
        mListView.setAdapter(adapter);

        for (int i = 0; i < 100; i++) {
            mList.add(String.valueOf(i));
        }
        adapter.replaceData(mList);
        mListView.addOnItemTouchListener(new OnRecyclerItemClickListener(mListView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

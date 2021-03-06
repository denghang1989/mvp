package fgecctv.com.appdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;
import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.data.model.bean.User;
import fgecctv.com.appdemo.ui.mvp.contract.UserContract;
import fgecctv.com.appdemo.ui.mvp.presenter.UserPresenter;
import fgecctv.com.appdemo.ui.recyclerview.CommonAdapter;
import fgecctv.com.appdemo.ui.recyclerview.DividerItemDecoration;
import fgecctv.com.appdemo.ui.recyclerview.OnRecyclerItemClickListener;
import fgecctv.com.appdemo.ui.recyclerview.ViewHolder;
import fgecctv.com.appdemo.utils.ImageLoader;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.fragment
 * @Description: (用户信息的Fragment)
 * @date 2016/5/24 16
 */
public class UserFragment extends BaseFragment implements UserContract.View {

    private CircleImageView mAvatar;
    private RecyclerView mListView;
    private CommonAdapter<String> mAdapter;

    @Override
    protected BasePresent getPresenter() {
        return new UserPresenter(DataManager.getInstance(mActivity, mRealm), this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAvatar = (CircleImageView) view.findViewById(R.id.avatar_image);
        mListView = (RecyclerView) view.findViewById(R.id.user_list);
        mAdapter = new CommonAdapter<String>(getHoldingActivity(), R.layout.item_user, new ArrayList<String>(0)) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.textView_title,s);
            }
        };
        mListView.addItemDecoration(new DividerItemDecoration(getHoldingActivity(),DividerItemDecoration.HORIZONTAL_LIST));
        mListView.setAdapter(mAdapter);
        mListView.addOnItemTouchListener(new OnRecyclerItemClickListener(mListView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh, int position) {
                Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();
            }
        });
        mListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING: // 手指滑动
                        // TODO: 2016/5/28   设置adapter 里面的滚动的标记  静止加载图片
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE: // 停止
                        // TODO: 2016/5/28  设置adapter 里面滚动的标记 开始加载图片
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING: // 屏幕滚动
                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public void showAvatar(String file) {
        mAvatar.setVisibility(View.VISIBLE);
        ImageLoader.display(this, file, mAvatar);
    }

    @Override
    public void showUserInfo(User user) {
        mListView.setVisibility(View.VISIBLE);
        String[] array = getContext().getResources().getStringArray(R.array.user_info);
        mAdapter.replaceData(Arrays.asList(array));
    }

}

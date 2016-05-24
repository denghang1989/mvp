package fgecctv.com.appdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.data.model.bean.User;
import fgecctv.com.appdemo.ui.mvp.contract.UserContract;
import fgecctv.com.appdemo.ui.mvp.presenter.UserPresenter;
import fgecctv.com.appdemo.ui.recyclerview.CommonAdapter;
import fgecctv.com.appdemo.ui.recyclerview.OnRecyclerItemClickListener;
import fgecctv.com.appdemo.ui.recyclerview.ViewHolder;
import fgecctv.com.appdemo.utils.ImageLoader;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/24 16
 */
public class UserFragment extends BaseFragment implements UserContract.View{

    private CircleImageView mAvatar;
    private RecyclerView mListView;
    private CommonAdapter<String> mAdapter;

    @Override
    protected BasePresent getPresenter() {
        return new UserPresenter(DataManager.getInstance(getHoldingActivity()),this);
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
        mAdapter = new CommonAdapter<String>(getHoldingActivity(), R.layout.item_user,new ArrayList<String>(0)) {
            @Override
            public void convert(ViewHolder holder, String s) {

            }
        };
        mListView.setAdapter(mAdapter);
        mListView.addOnItemTouchListener(new OnRecyclerItemClickListener(mListView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh, int position) {

            }
        });
    }

    @Override
    public void showAvatar(String file) {
        mAvatar.setVisibility(View.VISIBLE);
        ImageLoader.display(this,file,mAvatar);
    }

    @Override
    public void showUserInfo(User user) {
        mListView.setVisibility(View.VISIBLE);
        mAdapter.replaceData(null);
    }

}

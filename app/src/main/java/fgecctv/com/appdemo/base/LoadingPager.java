package fgecctv.com.appdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import fgecctv.com.appdemo.R;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/29 12
 */
public abstract class LoadingPager extends FrameLayout {

    private View mLoadingView;
    private View mErrorView;
    private View mRightView;
    private static final int    LOADING_STATE = 0;
    private static final int    ERROR_STATE   = 1;
    private static final int    RIGHT_STATE   = 2;
    private static final int    NONE_STATE    = 3;
    private              int    current_state = NONE_STATE;
    private static final String TAG           = "LoadingPager";

    public LoadingPager(Context context) {
        super(context);
        initCommonViews(context);
    }

    /**
     * @param context
     */
    private void initCommonViews(Context context) {
        // 数据加载中的页面
        mLoadingView = LayoutInflater.from(context).inflate(R.layout.pager_loading, null, false);
        this.addView(mLoadingView);
        // 错误页面
        mErrorView = LayoutInflater.from(context).inflate(R.layout.pager_error, null, false);
        this.addView(mErrorView);
        // 成功页面
        mRightView = LayoutInflater.from(context).inflate(getLayoutId(), null, false);
        this.addView(mRightView);

        refreshUIByState(current_state);
    }

    /**
     * @desc:根据状态刷新数据
     */
    public void refreshUIByState(int current_state) {
        mLoadingView.setVisibility(current_state == LOADING_STATE ? VISIBLE : GONE);
        mErrorView.setVisibility(current_state == ERROR_STATE ? VISIBLE : GONE);
        mRightView.setVisibility(current_state == RIGHT_STATE ? VISIBLE : GONE);
    }

    public void triggerLoadData() {
        // 没有加载成功 或者 不是正在加载中
        if (current_state != RIGHT_STATE && current_state != LOADING_STATE) {
            // 设置当前状态
            current_state = LOADING_STATE;
            refreshUIByState(current_state);
            // 加载数据
            initLoadData();
        }
    }

    /**
     * @desc 成功视图的ID
     */
    public abstract int getLayoutId();


    /**
     * @desc 通过回调的形式刷新UI
     */
    public abstract void initLoadData();

    public View getRightView() {
        return mRightView;
    }

    public enum SetState {
        ERROR(ERROR_STATE), RIGHT(RIGHT_STATE);
        int state;

        SetState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}

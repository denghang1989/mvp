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
    private View mEmptyView;
    private View mErrorView;
    private View mSuccessView;
    private static final int LOADING_STATE = 0;
    private static final int ERROR_STATE = 1;
    private static final int EMPTY_STATE = 2;
    private static final int SUCCESS_STATE = 3;
    private int current_state = LOADING_STATE;

    public LoadingPager(Context context) {
        super(context);
        initCommonViews(context);
    }

    /**
     * @param context
     */
    private void initCommonViews(Context context) {
        // 数据加载中的页面
        mLoadingView = LayoutInflater.from(context).inflate(R.layout.pager_loading, this, false);
        // 空页面
        mEmptyView = LayoutInflater.from(context).inflate(R.layout.pager_empty, this, false);
        // 错误页面
        mErrorView = LayoutInflater.from(context).inflate(R.layout.pager_error, this, false);

        refreshUIByState(current_state);
    }

    /**
     * @desc:根据状态刷新数据
     */
    private void refreshUIByState(int current_state) {
        mLoadingView.setVisibility(current_state == LOADING_STATE ? VISIBLE : GONE);
        mEmptyView.setVisibility(current_state == EMPTY_STATE ? VISIBLE : GONE);
        mErrorView.setVisibility(current_state == ERROR_STATE ? VISIBLE : GONE);

        if (current_state == SUCCESS_STATE && mSuccessView == null) {
            mSuccessView = initSuccessView();
            this.addView(mSuccessView);
        }

        if (mSuccessView != null) {
            mSuccessView.setVisibility(current_state == SUCCESS_STATE ? VISIBLE : GONE);
        }

    }

    public abstract View initSuccessView();

    public void triggerLoadData() {
        // 没有加载成功 或者 不是正在加载中
        if (current_state != SUCCESS_STATE && current_state != LOADING_STATE) {
            // 设置当前状态
            current_state = LOADING_STATE;
            refreshUIByState(current_state);

            // 加载数据
            initLoadData();
        }
    }


    /**
     * @desc 通过回调的形式刷新UI
     */
    protected abstract void initLoadData();

}

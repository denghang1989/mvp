package fgecctv.com.appdemo.ui.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> datas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1, datas);
        mMultiItemTypeSupport = multiItemTypeSupport;

        if (mMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getItemViewType(position, mData.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mMultiItemTypeSupport == null)
            return super.onCreateViewHolder(parent, viewType);

        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        ViewHolder holder = ViewHolder.get(mContext, null, parent, layoutId, -1);
        AutoUtils.autoSize(holder.getConvertView());
        return holder;
    }

}

package fgecctv.com.appdemo.base.recyclerview;

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
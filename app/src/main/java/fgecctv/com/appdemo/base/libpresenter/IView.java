package fgecctv.com.appdemo.base.libpresenter;

/**
 * Created by liuyedong on 2014/12/26.
 */
public interface IView {
    /**
     * Get presenter of view
     * @return
     */
    Presenter getPresenter();

    /**
     * Call after presenter#takeView
     * @param presenter
     */
    void onPresenterTaken(Presenter presenter);
}

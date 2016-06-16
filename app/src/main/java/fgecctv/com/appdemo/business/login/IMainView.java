package fgecctv.com.appdemo.business.login;

import fgecctv.com.appdemo.base.libpresenter.IView;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.business.login
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/6/15 09
 */
public interface IMainView extends IView {
    void setTitle(CharSequence title);

    String getAccount();

    String getPassword();

    void showLoading();

    void hideLoading();

    void enableSignIn();

    void disableSignIn();

    void handleSignInException(Throwable e);

    void handleSignInSuccess();
}

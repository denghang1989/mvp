package fgecctv.com.appdemo.ui.mvp.contract;

import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.base.BaseView;
import fgecctv.com.appdemo.data.model.bean.User;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.mvp.contract
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/24 17
 */
public interface UserContract {
    interface View extends BaseView {
        void showAvatar(String file); // 头像
        void showUserInfo(User user); // 用户信息
    }

    interface Presenter extends BasePresent {
        void modifyAvatar();
        void modifyAccount();
        void modefyNickname();
        void modefySex();
        void modefyAddress();
    }

}

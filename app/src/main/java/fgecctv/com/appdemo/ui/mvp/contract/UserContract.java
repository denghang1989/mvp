package fgecctv.com.appdemo.ui.mvp.contract;

import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.base.BaseView;

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
        void showAccount(String account); // 账号名称
        void showNickname(String nickname); // 呢称
        void showSex(String sex); // 性别
        void showAddress(String address); // 地址
    }

    interface Presenter extends BasePresent {
        void modifyAvatar();
        void modifyAccount();
        void modefyNickname();
        void modefySex();
        void modefyAddress();
    }

}

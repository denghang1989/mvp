package fgecctv.com.appdemo.data.model.pojo;

import fgecctv.com.appdemo.data.model.bean.User;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.model.pojo
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/25 12
 */
public class LoginResponse {
    private String token;
    private User mUser;

    public LoginResponse(String token, User user) {
        this.token = token;
        mUser = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}

package fgecctv.com.appdemo.data.model.bean;

import io.realm.annotations.Ignore;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.model.bean
 * @Description: (demo 演示 realm)
 * @date 2016/5/5 15
 */
public class User extends BaseData {
    private String name;
    private int    age;
    private String imageUrl;

    @Ignore
    private int sessionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

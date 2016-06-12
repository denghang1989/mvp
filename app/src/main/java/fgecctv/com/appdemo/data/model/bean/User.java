package fgecctv.com.appdemo.data.model.bean;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fgecctv.com.appdemo.data.local.dbmanager.AppDatabase;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.model.bean
 * @Description:
 * @date 2016/5/5 15
 */
@Table(database = AppDatabase.class)
public class User extends BaseModel {
    //自增ID
    @PrimaryKey(autoincrement = true)
    public  Long   id;
    @Column
    private String name;
    @Column
    private int    gender;
    @Column
    private String imageUrl;
}

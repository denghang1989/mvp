package fgecctv.com.appdemo.model.data.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fgecctv.com.appdemo.model.local.dbmanager.AppDatabase;

/**
 * @author denghang
 * @version V1.0
 * @Description:
 * @date 2016/5/5 15
 */
@Table(database = AppDatabase.class)
public class User extends BaseModel {
    //自增ID
    @PrimaryKey(autoincrement = true)
    public Long   id;
    @Column
    public String name;
    @Column
    public int    gender;
    @Column
    public String imageUrl;
}

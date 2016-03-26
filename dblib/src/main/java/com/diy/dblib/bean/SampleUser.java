package com.diy.dblib.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * @version V1.0 <表格：用户>
 * @author: Xs
 * @date: 2016-03-26 15:00
 * @email Xs.lin@foxmail.com
 */
@DatabaseTable(tableName = SampleUser.TABLE_NAME)
public class SampleUser implements Serializable {
    public static final String TABLE_NAME = "tb_user";

    public static final String USER_ID = "user_id";
    public static final String NAME = "name";
    public static final String PWD = "pwd";
    public static final String GENDER = "Gender";
    public static final String HEAD = "head";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false,columnName = USER_ID)
    private String user_id;
    @DatabaseField(columnName = NAME)
    private String name;
    @DatabaseField(columnName = PWD)
    private String pwd;
    @DatabaseField(columnName = GENDER)
    private String gender;
    @DatabaseField(columnName = HEAD)
    private String head;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "user infor{ [id="+id+" "+USER_ID+":"+user_id+" "+NAME+":"+name+" "+PWD+":"+pwd+" "+GENDER+":"+gender+" "+HEAD+":"+head+"]}";
    }

    public SampleUser(){}
    public SampleUser(String user_id,String name,String pwd,String gender,String head){
        this.user_id = user_id;
        this.name = name;
        this.pwd = pwd;
        this.gender = gender;
        this.head = head;
    }
}

package com.diy.dblib.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.diy.dblib.bean.SampleUser;
import com.diy.dblib.util.DatabaseHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-03-26 14:49
 * @email Xs.lin@foxmail.com
 */
public class SampleDatabaseHelper extends DatabaseHelper {
    private static final String TAG = "SampleDatabaseHelper";

    private static final String DB_NAME = "fii_watch.db";
    private static int DB_VERSION = 1;

    private SampleDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static SampleDatabaseHelper instance;
    /**
     * 单例获取该Helper
     * @param context
     * @return
     */
    public static synchronized SampleDatabaseHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (SampleDatabaseHelper.class) {
                if (instance == null)
                    instance = new SampleDatabaseHelper(context);
            }
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, SampleUser.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,SampleUser.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

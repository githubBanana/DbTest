package com.diy.dblib.test;

import android.content.Context;
import android.util.Log;

import com.diy.dblib.bean.SampleUser;
import com.diy.dblib.util.DatabaseHelper;
import com.diy.dblib.util.GenericDao;
import com.diy.dblib.util.GenericDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0 <数据库缓存>
 * @author: Xs
 * @date: 2016-03-26 14:49
 * @email Xs.lin@foxmail.com
 */
public class SampleDatabaseCache {
    private static final String TAG = "SampleDatabaseCache";

    private static SampleDatabaseCache instance;
    private Context mContext;

    private DatabaseHelper mDataHelper;
    private GenericDao<SampleUser,Integer> mUserGenericDao;

    /**
     * 单例获取
     * @param context
     * @return
     */
    public static SampleDatabaseCache getCache(Context context) {
        if (instance == null) {
            synchronized (SampleDatabaseCache.class) {
                if(instance == null) {
                    instance = new SampleDatabaseCache(context);
                }
            }
        }
        return instance;
    }

    private SampleDatabaseCache(Context context){
        this.mContext = context;
        mDataHelper = SampleDatabaseHelper.getHelper(mContext);
        mUserGenericDao = new GenericDaoImpl<>(mContext,mDataHelper,SampleUser.class);
    }

    public void CreateUserData() {
        for (int i = 0;i < 2;i++)
            mUserGenericDao.createOrUpdate(new SampleUser("ii"+i,"xs"+i,"111","m","head"));
        for (int i = 0;i < 10;i++)
            mUserGenericDao.createOrUpdate(new SampleUser("ii"+i,"xs"+i,""+i,"m"+i,"head"+i));
        List<SampleUser> lists = new ArrayList<>();
        lists = mUserGenericDao.queryForAll();
        Log.i("test", "lists.size=" + lists.size());
        for (int i = 0;i < lists.size();i++) {
            Log.i(TAG,"queryForAll:\n"+lists.get(i).toString());
        }
        Map<String,Object> map = new HashMap<>();
        map.put(SampleUser.USER_ID,"ii0");
        Map<String,Object> map333 = new HashMap<>();
        map333.put(SampleUser.HEAD,"headhead");
        map333.put(SampleUser.GENDER,"yy");
        map333.put(SampleUser.NAME, "linxiaosheng");
        map333.put(SampleUser.USER_ID,"xixixi");

        mUserGenericDao.updateByFieldValues(map,map333);
        List<SampleUser> lists22 = new ArrayList<>();
        lists22 = mUserGenericDao.queryForAll();
        Log.i("test","lists22.size="+lists22.size());

        for (int i = 0;i < lists22.size();i++) {
            Log.i(TAG,"queryForAll22:\n"+lists22.get(i).toString());
        }
        /*List<SampleUser> lists1 = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put(SampleUser.USER_ID,"iir");
        map.put(SampleUser.HEAD,"head0");
        lists1 = mUserGenericDao.queryForFieldValues(map);
        for (int i = 0;i < lists1.size();i++) {
            Log.i(TAG,"queryForFieldValues:\n"+lists1.get(i).toString());
        }*/

        Map<String,Object> map3 = new HashMap<>();
        map3.put(SampleUser.HEAD,"head00");
        SampleUser user = mUserGenericDao.queryForFieldValuesAndFirst(map3);
        if(user == null)
            Log.i(TAG, "queryForFieldValuesAndFirst:nullnull\n" );




    }


}

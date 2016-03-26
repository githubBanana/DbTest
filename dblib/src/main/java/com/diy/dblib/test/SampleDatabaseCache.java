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
        for (int i = 0;i < 10;i++)
            mUserGenericDao.createOrUpdate(new SampleUser("ii"+i,"xs"+i,""+i,"m"+i,"head"+i));
        List<SampleUser> lists = new ArrayList<>();
        lists = mUserGenericDao.queryForAll();
        for (int i = 0;i < lists.size();i++) {
            Log.i(TAG,"queryForAll:\n"+lists.get(i).toString());
        }
      /*  List<SampleUser> lists = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put(SampleUser.NAME,"xs");
        lists = mUserGenericDao.queryForFieldValues(map);
        for (int i = 0;i < lists.size();i++) {
            Log.i(TAG,"queryForFieldValues:\n"+lists.get(i).toString());
        }*/

/*        SampleUser user = mUserGenericDao.queryForFieldValuesAndFirst(map);
        Log.i(TAG, "queryForFieldValuesAndFirst:\n" + user.toString());*/


        List<SampleUser> user3 = mUserGenericDao.queryForEq(SampleUser.HEAD,"head4");
        for (int i = 0;i < user3.size();i++) {
            Log.i(TAG,"queryForEq:\n"+user3.get(i).toString());
        }

    }


}

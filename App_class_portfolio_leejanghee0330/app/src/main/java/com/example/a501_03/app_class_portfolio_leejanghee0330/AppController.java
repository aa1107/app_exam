package com.example.a501_03.app_class_portfolio_leejanghee0330;

import android.app.Application;

import com.example.a501_03.app_class_portfolio_leejanghee0330.db.DaoMaster;
import com.example.a501_03.app_class_portfolio_leejanghee0330.db.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 501-03 on 2018-04-06.
 */

public class AppController extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"my_portfolio");
        Database db=helper.getWritableDb();
        daoSession=new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
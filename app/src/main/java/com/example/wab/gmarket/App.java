package com.example.wab.gmarket;

import android.app.Application;
import cn.bmob.v3.Bmob;

/**
 * Created by wab on 17-3-19.
 */

public class App extends Application{
    @Override public void onCreate() {
        super.onCreate();

        initBmob();
    }

    private void initBmob() {
        Bmob.initialize(this, "6a05ce4554897dc641d18bfea471c7e4");
    }
}

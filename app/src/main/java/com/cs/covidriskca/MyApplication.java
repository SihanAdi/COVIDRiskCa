package com.cs.covidriskca;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static MyApplication instance;
    public Context context;
    public static String username;
    public static User user;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();

    }
}

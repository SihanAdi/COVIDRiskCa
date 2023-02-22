package com.cs.covidriskca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper( Context context) {
        super(context, "zdw.db", null, 1);// 1 表示数据库的版本，当传递2时
        System.out.println("SqlHelper :" + SqlHelper.this);
    }
    public volatile static SqlHelper sqlHelper;
    public static SqlHelper getInstance(Context context){
        if (sqlHelper == null){
            synchronized (SqlHelper.class){
                if (sqlHelper == null){
                    sqlHelper = new SqlHelper(context);
                }
            }
        }
       return sqlHelper;
    }
//  这个方法是数据库第一次创建时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("SqlHelper 数据库中的用户表创建了");
        String sql = "create table user (_id integer primary key autoincrement,username varchar(30),password varchar(30),sex varchar(50),picPath varchar(200))";
        db.execSQL(sql);
//        创建商品表
        String sql2 = "create table product (_id integer primary key autoincrement,username varchar(50),goodsName varchar(50),goodsPrice varchar(50),goodsCategory varchar(50),goodsPhone varchar(50),goodsPath varchar(200),goodsBuyed varchar(50),goodsTime varchar(50),goodsBuyedUser varchar(200),goodsBuyedCar varchar(50),goodsAddBuyedcarUser varchar(200))";
        db.execSQL(sql2);
        System.out.println("SqlHelper 数据库中的商品表创建了");

        //        创建留言表
        String sql3 = "create table comment (_id integer primary key autoincrement,goodId varchar(30),setCurrentTime varchar(50),goodsLiuyan varchar(1000))";
        db.execSQL(sql3);
        System.out.println("SqlHelper 数据库中的留言表创建了");
    }
//数据库版本发生变化 时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("SqlHelper 数据库更新了。。。");
    }
}

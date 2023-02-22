package com.cs.covidriskca;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {
    private static UserDao userDaoInstance = new UserDao();
    private final SqlHelper helper;

    public static UserDao getInstance() {
        return userDaoInstance;
    }

    private UserDao() {
        helper = new SqlHelper(MyApplication.instance.context);
    }

    public long insertUser(User user) {
        User registerUser = registerFindUser(user);
        if(registerUser != null){
            System.out.println("该用户已经存在请 重新注册");
            return -1000;
        }
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();//开启I事务
        ContentValues value = new ContentValues();
        value.put("username", user.getUsername());
        value.put("password", user.getPassword());
        value.put("sex", user.getSex());
        long raw = db.insert("user", null, value);
        db.setTransactionSuccessful();//告诉系统事务已经都ok了，一定要调此方法，不调的话，数据无法插入
        db.endTransaction();//结束事务
        db.close();
        System.out.println("insertUser raw " + raw);
        return raw;
    }
    public User registerFindUser(User user){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("user", null, "username = ?", new String[]{user.getUsername()}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String username = cursor.getString(1);//从0开始
                String password = cursor.getString(2);//从0开始
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPassword(password);
                cursor.close();
                db.close();
                return newUser;
            }
            cursor.close();
            db.close();
        }
        return null;
    }
    public User findUser(User user) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("user", null, "username = ? and password = ?", new String[]{user.getUsername(), user.getPassword()}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String username = cursor.getString(1);//从0开始
                String password = cursor.getString(2);//从0开始
                String sex = cursor.getString(3);//性别
                String picPath = cursor.getString(4);//用户图像
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPassword(password);
                newUser.setSex(sex);
                newUser.setPicPath(picPath);
                cursor.close();
                db.close();
                return newUser;
            }
            cursor.close();
            db.close();
        }
        return null;
    }
//    修改密码，根据用户名进行密码修改
	public int updateUserPassword(User user){
        SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues newValues = new ContentValues();
		newValues.put("password", user.getPassword());
//		newValues.put("sex",user.getSex());
//        newValues.put("picPath",user.getPicPath());
		String[] args = new String[]{user.getUsername()};
        int raw = db.update("user", newValues, "username=?", args);
        db.close();
        return raw;
    }
    public int updateUserPicPath(User user){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("picPath", user.getPicPath());
//		newValues.put("sex",user.getSex());
//        newValues.put("picPath",user.getPicPath());
        String[] args = new String[]{user.getUsername()};
        int raw = db.update("user", newValues, "username=?", args);
        db.close();
        return raw;
    }
}

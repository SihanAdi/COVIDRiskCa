package com.cs.covidriskca;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView backArrow;
    private TextView tvTitle;
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;

    private Boolean bPwdSwitch = false;
    private EditText etPwd;

    private EditText etAccount;
    private CheckBox cbRememberPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin =  findViewById(R.id.btnLogin);
        etUserName = findViewById(R.id.etUserName) ;backArrow = findViewById(R.id.backArrow);
        etPassword = findViewById(R.id.etPassword) ;
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvTitle = findViewById(R.id.tvTitle);
        final ImageView ivPwdSwitch = findViewById(R.id.iv_pwd_switch);
        etPwd = findViewById(R.id.etPassword);

        ivPwdSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bPwdSwitch = !bPwdSwitch;
                if(bPwdSwitch){
                    ivPwdSwitch.setImageResource(
                            R.drawable.ic_visibility_black_24dp
                    );
                    etPwd.setInputType(
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    );
                }else{
                    ivPwdSwitch.setImageResource(
                            R.drawable.ic_visibility_off_black_24dp
                    );
                    etPwd.setInputType(
                            InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT
                    );
                    etPwd.setTypeface(Typeface.DEFAULT);
                }
            }
        });

        findViewById(R.id.tvRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startLogin();
//                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });
        //verifyStoragePermissions(this);

        etPwd=findViewById(R.id.etPassword);
        etAccount=findViewById(R.id.etUserName);

        Button btLogin=findViewById(R.id.btnLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });

//        String spFileName=getResources().getString(R.string.shared_preferences_file_name);
//        String accountKey=getResources().getString(R.string.login_account_name);
//        String passwordKey=getResources().getString(R.string.login_password);
//        String rbPasswordKey=getResources().getString(R.string.login_remember_password);

//        SharedPreferences spFile=getSharedPreferences(spFileName,MODE_PRIVATE);
//        String account=spFile.getString(accountKey,null);
//        String password=spFile.getString(passwordKey,null);
//        Boolean rbPassword=spFile.getBoolean(rbPasswordKey,false);

//        if(account!=null&&!TextUtils.isEmpty(account))
//        {
//            etAccount.setText(account);
//        }
//        if(password!=null&&!TextUtils.isEmpty(password))
//        {
//            etPwd.setText(password);
//        }




    }

    public void onClick(View view)
    {
        //startLogin();
//        String spFileName=getResources().getString(R.string.shared_preferences_file_name);
//        String accountKey=getResources().getString(R.string.login_account_name);
//        String passwordKey=getResources().getString(R.string.login_password);
//        String rbPasswordKey=getResources().getString(R.string.login_remember_password);
//
//        SharedPreferences spFile=getSharedPreferences(spFileName, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=spFile.edit();
//
//
        String password=etPwd.getText().toString();
        String account =etAccount.getText().toString();
//
//        editor.putString(accountKey,account);
//        editor.putString(passwordKey,password);
//        editor.putBoolean(rbPasswordKey,true);
//        editor.apply();
//
//        editor.remove(accountKey);
//        editor.remove(passwordKey);
//        editor.remove(rbPasswordKey);
//        editor.apply();
    }

    private  final int REQUEST_EXTERNAL_STORAGE = 1;
    private  String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };


    public void verifyStoragePermissions(Activity activity) {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startLogin() {
//        String[] editTextContent = getEditTextContent();
//        String username = editTextContent[0];
//        String password = editTextContent[1];
//        if (username == null || "".equals(username) || password == null || "".equals(password)) {
//            //账户或者密码为空
//            //UiUtils.toast("Username or password cannot be empty");
//            Toast toast=Toast.makeText(this,"Username or password cannot be empty",Toast.LENGTH_LONG);
//            toast.show();
//            return;
//        }
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        User newUser = UserDao.getInstance().findUser(user);
//        if (newUser != null){
////            UiUtils.toast("登录成功");
//            MyApplication.username = username;
//            MyApplication.user = newUser;
//            System.out.println("currentTimeMillis Login:" + System.currentTimeMillis());
        String [] a = getEditTextContent();
        if (a[0] == null || "".equals(a[0]) || a[1] == null || "".equals(a[1]) ) {


            Toast toast=Toast.makeText(this,"User name, password cannot be empty",Toast.LENGTH_LONG);
            toast.show();
            return;
        }
            startActivity(new Intent(MainActivity.this,InformationCollection.class));
//        }else {
//            //UiUtils.toast("Login failed");
//        }
    }

    private String[] arr = new String[2];
    public String[] getEditTextContent(){
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        arr[0] = username;
        arr[1] = password;
        return arr;
    }


}
package com.cs.covidriskca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private ImageView backArrow;
    private EditText etUserName;
    private EditText etPassword;
    private EditText et_again;
    private Button btnRegister;
    private RadioGroup sexRadioGroup;
    private String sexStr = "男";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        etUserName = findViewById(R.id.etUserName) ;
        etPassword = findViewById(R.id.etPassword) ;
        et_again = findViewById(R.id.et_again);
        btnRegister = findViewById(R.id.btnRegister) ;
        sexRadioGroup = findViewById(R.id.sexRadioGroup);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }
    private String[] arr = new String[3];
    public String[] getEditTextContent(){
        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        arr[0] = username;
        arr[1] = password;
        return arr;
    }
    private void register() {
        String[] editTextContent = getEditTextContent();
        String username = editTextContent[0];
        String password = etPassword.getText().toString().trim();
        String Dermindpassword = et_again.getText().toString().trim();
        if (username == null || "".equals(username) || password == null || "".equals(password) || Dermindpassword == null || "".equals(Dermindpassword)) {


            Toast toast=Toast.makeText(this,"User name, password, and confirm password cannot be empty",Toast.LENGTH_LONG);
            toast.show();
            return;
        }else if(!Dermindpassword.equals(password)) {

            Toast toast=Toast.makeText(this,"Password and confirm password are not the same",Toast.LENGTH_LONG);
            toast.show();
            return;
        }
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setDermindPassword(Dermindpassword);
//        user.setSex(sexStr);
//        long raw = UserDao.getInstance().insertUser(user);
//        if(raw == -1000){
//            //UiUtils.toast("This user name already exists");
//            Toast toast=Toast.makeText(this,"This user name already exists",Toast.LENGTH_LONG);
//            toast.show();
//        }else if(raw == 0){
//            //UiUtils.toast("registration failed");
//            Toast toast=Toast.makeText(this,"registration failed",Toast.LENGTH_LONG);
//            toast.show();
//        }else if(raw > 0){
//            //UiUtils.toast("registration success");
            Toast toast=Toast.makeText(this,"registration success",Toast.LENGTH_LONG);
            toast.show();
            finish();
       // }

    }
}
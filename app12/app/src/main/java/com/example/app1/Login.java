package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
/*
* 登录
* 2022-5-17 袁泉
* 2022-6-12 袁泉
* 2022-6-13 袁泉
* */
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editText1 = (EditText) findViewById(R.id.login_edit_account);
        EditText editText2 =(EditText) findViewById (R.id.login_edit_pwd);
        SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);

        editText1.setText(sp.getString("user",""));
        if(sp.getBoolean("save",true) == true) {
            editText2.setText(sp.getString("pwd",""));
        }
    }
    public void finish_login(View view) {
        String pwd;
        String user;
        SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        EditText editText1 =(EditText) findViewById (R.id.login_edit_pwd);
        pwd = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.login_edit_account);
        user = editText2.getText().toString();
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.Login_Remember);


        if(user.equals("SIAT100019")){
            if(pwd.equals("100019")){
                editor.putString("user",user);
                if(checkBox1.isChecked()) {
                    editor.putBoolean("save",true);
                    editor.putString("pwd",pwd);
                } else {
                    editor.putBoolean("save",false);
                    editor.putString("pwd","");
                }
                editor.putBoolean("isLogin",true);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }

        }
        editor.commit();
    }



}
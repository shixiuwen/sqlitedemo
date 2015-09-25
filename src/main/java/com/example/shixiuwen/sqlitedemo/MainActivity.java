package com.example.shixiuwen.sqlitedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shixiuwen.helper.DatabaseHelper;


public class MainActivity extends ActionBarActivity {


    SQLiteDatabase db;
    Button btnLogin;
    Button btnRegister;
    EditText etName;
    EditText etPwd;
    String name;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper database = new DatabaseHelper(MainActivity.this, null, null, 1);
        db = database.getReadableDatabase();
        database.onCreate(db);

        btnLogin = (Button) findViewById(R.id.id_btn_login);
        btnRegister = (Button) findViewById(R.id.id_btn_register);
        etName = (EditText) findViewById(R.id.et_name);
        etPwd = (EditText) findViewById(R.id.et_pwd);

        name = etName.getText().toString();
        pwd = etPwd.getText().toString();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterPage.class);
                startActivity(intent);
            }
        });
    }

    public void search() {
        boolean flag = false;

        Cursor c = db.rawQuery("select * from nihao where username = ?", new String[]{name});
        if (c.moveToNext()) {
            if(pwd == c.getString(c.getColumnIndex("password"))){
                flag = true;
                Intent i = new Intent(MainActivity.this, MainPage.class);
                startActivity(i);
            }
        }
        Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();

    }
}

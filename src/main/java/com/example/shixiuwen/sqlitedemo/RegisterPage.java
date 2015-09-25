package com.example.shixiuwen.sqlitedemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shixiuwen.helper.DatabaseHelper;

/**
 * Created by shixiuwen on 15-9-25.
 */
public class RegisterPage extends Activity{

    SQLiteDatabase db;
    DatabaseHelper ah;
    String name;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        EditText reName = (EditText)findViewById(R.id.re_et_name);
        EditText rePwd = (EditText)findViewById(R.id.re_et_pwd);
        Button btnReRegister = (Button)findViewById(R.id.re_btn_register);

        ah = new DatabaseHelper(this,null,null,0);
        db = ah.getWritableDatabase();

        name = reName.getText().toString();
        pwd = rePwd.getText().toString();

        btnReRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sql = "insert into nihao(username,password) values (name,pwd);";
                db.execSQL(sql);
                finish();
            }
        });


    }
}

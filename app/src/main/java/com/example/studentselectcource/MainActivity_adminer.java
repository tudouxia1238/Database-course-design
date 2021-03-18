package com.example.studentselectcource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity_adminer extends Activity  {

    public Button info_handle_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_adminer_login);
        info_handle_btn = (Button) findViewById(R.id.info_handle_btn);
        info_handle_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity_adminer.this,InfoHandleActivity.class);
                startActivity(intent);
            }


        });
    }}

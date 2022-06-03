package com.example.myapplication;

import android.content.Intent;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.saul1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.saul1);
            }
        });
        findViewById(R.id.saul2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.saul2);
            }
        });
        findViewById(R.id.saul3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.saul3);
            }
        });
        findViewById(R.id.saul4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.saul4);
            }
        });
        findViewById(R.id.how1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.how1);
            }
        });
        findViewById(R.id.how2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.how2);
            }
        });
        findViewById(R.id.how3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.how3);
            }
        });
        findViewById(R.id.how4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.how4);
            }

        });


        findViewById(R.id.bat1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.bat1);
            }
        });

        findViewById(R.id.bat2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.bat2);
            }
        });
        findViewById(R.id.bat3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.bat3);
            }
        });
        findViewById(R.id.bat4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainGec("android.resource://"+getPackageName()+"/"+R.raw.bat4);
            }
        });



    }
    void mainGec(String key){
        Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
        intent.putExtra("key",key);
        startActivity(intent);
    }
}

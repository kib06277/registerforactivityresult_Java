package com.example.registerforactivityresult_java;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

//首頁
public class MainActivity extends AppCompatActivity {

    //基本宣告
    MaterialButton amMbSaber , amMbArcher;
    Intent intent;
    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(); //程式和 xml 關聯
        initClickListener(); //點擊事件
    }

    //程式和 xml 關聯
    private void findViewById(){
        amMbSaber = findViewById(R.id.amMbSaber);
        amMbArcher = findViewById(R.id.amMbArcher);
    }

    //點擊事件
    private void initClickListener() {
        amMbSaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(MainActivity.this , ArcherActivity.class);
                    intent.putExtra("name", "Arthur");
                    resultLauncher.launch(intent);
                } catch (Exception e){
                    Log.i("EE" , "E = " + e);
                }
            }
        });


        amMbArcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = new Intent(MainActivity.this , SaberActivity.class);
                    intent.putExtra("name", "Emiya");
                    resultLauncher.launch(intent);
                } catch (Exception e){
                    Log.i("EE" , "E = " + e);
                }
            }
        });

        //回傳處理
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                int resultCode = result.getResultCode();
                if (RESULT_OK == resultCode) {
                    Log.d("maho", "回傳:" + result.getData().getStringExtra("weapon"));
                }
            }
        });
    }
}
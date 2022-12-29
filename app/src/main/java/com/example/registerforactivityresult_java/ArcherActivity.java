package com.example.registerforactivityresult_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

//第二個跳轉頁面
public class ArcherActivity extends AppCompatActivity {

    //基本宣告
    MaterialButton aaMbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archer);
        findViewById(); //程式和 xml 關聯
        initClickListener(); //點擊事件
    }

    //程式和 xml 關聯
    private void findViewById(){
        aaMbMain = findViewById(R.id.aaMbMain);
    }

    private void initClickListener() {
        aaMbMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArcherActivity.this , MainActivity.class);
                intent.putExtra("weapon", "Unlimited Blade Works");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

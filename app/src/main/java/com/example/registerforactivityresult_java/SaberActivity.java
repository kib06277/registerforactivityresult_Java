package com.example.registerforactivityresult_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

//第一個跳轉頁面
public class SaberActivity extends AppCompatActivity {

    //基本宣告
    MaterialButton asMbMain;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saber);

        //解析
        intent = this.getIntent();//取得傳遞過來的資料
        String name = intent.getStringExtra("name");
        Log.d("maho", "姓名:" + name);


        findViewById(); //程式和 xml 關聯
        initClickListener(); //點擊事件
    }

    //程式和 xml 關聯
    private void findViewById(){
        asMbMain = findViewById(R.id.asMbMain);
    }

    //點擊事件
    private void initClickListener() {
        asMbMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaberActivity.this , MainActivity.class);
                intent.putExtra("weapon", "Unlimited Blade Works");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

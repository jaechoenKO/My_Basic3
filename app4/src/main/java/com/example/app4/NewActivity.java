package com.example.app4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // 버튼 클릭 시 MainActivity로 돌아감
        Button backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
            }
        });

    }

    // BACK 키 누렀을 때 액티비티 닫고 메인화면으로 이동
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // BACK키 눌렀을 때
        if(keyCode == event.KEYCODE_BACK){
            close();
            return true;
        }

        return false;

    }

    // 엑티비티를 닫는 메소드
    private void close(){

        // 응답 값을 전달 하기 위한 인텐트
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", "눌렸음");

        // 응닶 값 전달
        setResult(Activity.RESULT_OK, resultIntent);

        // 액티비티 닫기, 애플리케이션에 의해 의도적으로 종료
        finish();

    }
}

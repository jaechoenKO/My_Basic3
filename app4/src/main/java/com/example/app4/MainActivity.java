package com.example.app4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Intent 사용을 위한 REQUEST_CODE
    public static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn01);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // new Activity로 전환
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        // 버튼의 배경색 지정하기
        btn.setBackgroundColor(0x8800ff00);
    }

    // NewActivity 에서 응답을 받았을 때
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==REQUEST_CODE){
            Toast toast = Toast.makeText(getBaseContext(), "요청코드" + resultCode, Toast.LENGTH_LONG);
            toast.show();

            if(resultCode == Activity.RESULT_OK){
                String name = data.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(), "응답 이름 : " + name, Toast.LENGTH_LONG);
                toast.show();
            }

        }

    }
}

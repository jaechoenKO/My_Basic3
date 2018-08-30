package com.example.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv01);
        Button bt = findViewById(R.id.btn01);
        ImageView iv = findViewById(R.id.iv01);
        EditText et = findViewById(R.id.et01);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "텍스트뷰 클릭 이벤트 발생", Toast.LENGTH_LONG).show();
            }
        });

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "버튼 클릭 이벤트 발생", Toast.LENGTH_LONG).show();
            }
        });

        iv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(getBaseContext(), "이미지 터치 이벤트 발생", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        /**
         * TextChangeListener
         * **/
        et.addTextChangedListener(new TextWatcher() {

            /**
             * CharSequence : 사용자가 edit 텍스트에 입력할 문자열
             * start : 사용자가 입력한 문자열의 시작 위치 값.
             * before : 기존 문자 열의 수
             * count : 새로 추가된 문자열의 수
             * start 지점에서 시작 되는 before 갯 수 만큼의 글자들이 해당 count 갯 수 만큼의 글자들도 대치가 되었을 때 호출
             * 즉 텍스트가 변경 될 때 마다 발생할 이벤트
             * **/
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getBaseContext(), "onText(Changed()) 이벤트 발생"+charSequence.toString(), Toast.LENGTH_LONG).show();
            }

            /**
             * CharSequence : 사용자가 edit 텍스트에 입력할 문자열
             * start : 사용자가 입력한 문자열의 시작 위치 값.
             * count : 새로 추가된 문자열의 수
             * after : 새롭게 추가 할(될) 문자열의 수
             * 텍스트의 길이가 변경 후에 발생할 이벤트
             * **/
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                Toast.makeText(getBaseContext(), "텍스트의 길이 가 변경 됨" + charSequence.toString(), Toast.LENGTH_LONG).show();
            }

            /**
             * 텍스트가 변경 후에 발생할 이벤트
             * **/
            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getBaseContext(), "텍스트가 변경 됨"+editable.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}

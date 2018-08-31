package com.example.app7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.ex_t);
        editText2 = findViewById(R.id.ex_y);

    }

    public void btnClicked(View view) {

        try {

            Toast toast = Toast.makeText(getBaseContext(), "토스트 위치 설정", Toast.LENGTH_LONG);

            int xLoc = Integer.valueOf(editText1.getText().toString());
            int yLoc = Integer.valueOf(editText2.getText().toString());

            /**
             * setGravity() : 토스트 위치를 지정하는 메소드.
             * 세 개의 인자가 들어간다.
             * int Gravity : 정렬을 나타냄.
             * int xOffset : x 좌표, 허용 범위 : -160 ~ 160
             * int yOffset : y 좌표, 허용 범위 : -240 ~ 240
             * 허용 범위는 기기 마다 다르다.
             * **/
            toast.setGravity(Gravity.CENTER, xLoc, yLoc);
            toast.show();

        } catch (NumberFormatException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.app8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn01Clicked(View view) {

        // 토스트의 shape를 설정한 View
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_shape, (ViewGroup)findViewById(R.id.tv_shape_root)); // 레이아웃의 부모를 적어야 한다. ViewGroup으로 캐스팅 해야한다.

        /**
         * textView에 들어갈 객체는 toastView안에 있는 텍스트
         * 토스트에 보여줄 메세지 설정
         * **/
        TextView textView = toastView.findViewById(R.id.tv_shape);
        textView.setText("토스트 모양 바뀜");

        // 토스트 생성
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 400);
        // setDuration 토스트가 보여질 시간
        toast.setDuration(Toast.LENGTH_LONG);

        // 토스트 보여지고, 만든 모양을 설정 즉 토스트에 뷰 설정
        toast.setView(toastView);
        toast.show();
    }

}

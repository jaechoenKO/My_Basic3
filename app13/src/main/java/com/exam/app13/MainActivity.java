package com.exam.app13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Animation testAni;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 애니메이션의 객체화. AnimationUtils에 있는 loadAnimation을 가져온다.
        testAni = AnimationUtils.loadAnimation(this, R.anim.ani_test);
        textView = findViewById(R.id.tv01);

    }

    public void btnClicked(View view) {

        // 애니메이션 리스너 등록.
        testAni.setAnimationListener(new TestAnimaionListener());

        // 애니메이션 시작, 텍스트뷰에 애니메이션 적용
        textView.startAnimation(testAni);

    }

    private final class TestAnimaionListener implements Animation.AnimationListener{

        // 애니메이션 시작
        @Override
        public void onAnimationStart(Animation animation) {

        }

        // 애니메이션 끝
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(getApplicationContext(), "Animation End", Toast.LENGTH_LONG).show();
        }

        // 애니메이션 반복
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}

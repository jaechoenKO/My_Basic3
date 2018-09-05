package com.example.app14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 슬라이딩 처리를 위한 변수 선언
    boolean isPageShow = false;

    // 애니메이션 객체 선언
    Animation sliding_left;
    Animation sliding_right;

    // 애니메이션 적용할 레이아웃
    LinearLayout slidingPage;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn01);

        // 슬라이딩 처리를 위한 뷰 참조
        slidingPage = findViewById(R.id.page01);

        // xml에 정의된 애니메이션 액션을 객체화 하는 과정. 즉 로딩 과정
        sliding_left = AnimationUtils.loadAnimation(this, R.anim.sliding_left);
        sliding_right = AnimationUtils.loadAnimation(this, R.anim.sliding_right);

        SlidingAnimationListener animationListener = new SlidingAnimationListener();

        // 애니메이션 리스너 등록
        sliding_left.setAnimationListener(animationListener);
        sliding_right.setAnimationListener(animationListener);

    }

    private class SlidingAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if(isPageShow){
                // 화면 보이게 하기
                slidingPage.setVisibility(View.INVISIBLE);
                btn.setText("SHOW");
                isPageShow = false;
            }else{
                btn.setText("HIDE");
                isPageShow = true;
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

    public void btnClicked(View view) {

        if(isPageShow){
            slidingPage.setVisibility(View.GONE);
            slidingPage.setAnimation(sliding_right);

        }else{
            slidingPage.setVisibility(View.VISIBLE);
            slidingPage.startAnimation(sliding_left);
        }

    }
}

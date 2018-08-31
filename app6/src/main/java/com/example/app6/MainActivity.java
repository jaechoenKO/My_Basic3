package com.example.app6;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 전체화면 보기 window 객체를 이용해야 한다.
        final Window window = getWindow(); // 윈도우 객체를 얻어 온다.

        /**
         * windowmanager를 이용한다. 안드로이드 프레임워크에서 제공된다.
         **/
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    /**
     * Manifest에서 액티비티 전환을 지정 하면 불러오는 메소드
     * **/
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 단말기의 방향이 가로 방향으로 전환 LANDSCAPE : 가로전환
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "가로 방향으로 전환", Toast.LENGTH_SHORT).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){ // 세로 방향으로 전환 PORTRAIT : 세로
            Toast.makeText(this, "세로 방향으로 전환", Toast.LENGTH_SHORT).show();
        }

    }
}

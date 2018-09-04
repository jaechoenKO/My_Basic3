package com.example.app12_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * SeekBar 리스너에는 OnSeekBarChangeListener가 있다. 여기에는
     * void OnStartTrackingTouch(SeekBar seekBar)
     * void OnStopTracingTouch(SeekBar seekBar)
     * void OnProgressChanged(Seekbar seekBar, int Progress, boolean fromUser)
     * fromUser는 사용자의 입력에 의해 변한 것인지 해당 코드에 의해서 변한 것인지 구분.
     * 오버라이드 되는 메소드 들이 있다.
     * **/

    private View sView;
    private SeekBar seekBar;
    private TextView textView;

    /**
     * 화면 밝기 변수
     * **/
    private int brightness = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sView = findViewById(R.id.seekView);
        textView = findViewById(R.id.tvt01);
        seekBar = findViewById(R.id.seekBar01);

        Button showBtn = findViewById(R.id.btnShow);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSeekBar();
            }
        });

        // 시크바 리스너
        seekBar.setOnSeekBarChangeListener(new MyListener());


    }

    private void showSeekBar(){

        // 밝기 설정
        seekBar.setProgress(brightness);
        // 화면에 나타내기
        sView.setVisibility(View.VISIBLE);
    }

    private void hideSeekBar(){

        sView.setVisibility(View.GONE);

    }

    // 시크바 밝기 설정 메소드
    private void setBrightness(int value){

        if(value < 10){
            value = 10;
        }else if(value > 100){
            value = 100;
        }

        brightness = value;

        // 화면 밝기 설정을 위해서는 윈도우 매니저가 필요하다. 해당 윈도우에 대한 속성 값 즉 파라미터를 가져올 수 있다.
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value/100;

        // 얻어옴 params 정보를 세팅 해준다.
        getWindow().setAttributes(params);

    }

    /**
     * 시크바 내부 클래스 리스너
     * **/
    class MyListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            setBrightness(progress);
            textView.setText("현재 밝기 상태 : " + progress);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {



        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            hideSeekBar();
        }
    }

}

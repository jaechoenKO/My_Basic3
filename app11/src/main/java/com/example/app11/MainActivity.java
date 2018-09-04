package com.example.app11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * progressbar 의 형태는
 * Spinner : 원형
 * Horizontal : 막대모양
 *
 * 막대모양은 언제 끝나는지 알 수 있을 때 사용.
 * 원형 모양은 언제 끝날지 모를 때 사용. ex) 네트워크 연결
 *
 * **/

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar_horizontal;
    private ProgressBar progressBar_spinner;

    private Button btnProgress;
    private Button btnReset;
    private Button btnShow;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_horizontal = findViewById(R.id.pb01);
        progressBar_spinner = findViewById(R.id.pb02);

        btnProgress = findViewById(R.id.btn_progress);
        btnReset = findViewById(R.id.btn_reset);
        btnShow = findViewById(R.id.btn_show);
        btnHide = findViewById(R.id.btn_hide);

        btnProgress.setOnClickListener(listener);
        btnReset.setOnClickListener(listener);
        btnShow.setOnClickListener(listener);
        btnHide.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_progress:
                    Toast.makeText(getBaseContext(), "Progress", Toast.LENGTH_SHORT).show();
                    // incrementProgressBy : 얼마씩 추가 시킬 것인지.
                    progressBar_horizontal.incrementProgressBy(5);
                    // incrementSecondaryProgressBy : 세컨더리 프로그래스바를 얼마씩 추가 할 것인지.
                    progressBar_horizontal.incrementSecondaryProgressBy(10);
                    break;

                case R.id.btn_reset:
                    Toast.makeText(getBaseContext(), "Reset", Toast.LENGTH_SHORT).show();
                    // 프로그래스를 0으로 설정
                    progressBar_horizontal.setProgress(0);
                    // 세컨더리 프로그래스를 0으로 설정
                    progressBar_horizontal.setSecondaryProgress(0);
                    break;

                case R.id.btn_show:
                    Toast.makeText(getBaseContext(), "Show", Toast.LENGTH_SHORT).show();
                    // 프로그래스바를 보여 줄 것인지.
                    progressBar_spinner.setVisibility(ProgressBar.VISIBLE);
                    break;

                case R.id.btn_hide:
                    Toast.makeText(getBaseContext(), "Hide", Toast.LENGTH_SHORT).show();
                    progressBar_spinner.setVisibility(ProgressBar.INVISIBLE);
                    break;

            }
        }
    };

}

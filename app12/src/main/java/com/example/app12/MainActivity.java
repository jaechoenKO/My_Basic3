package com.example.app12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button progressBtn;
    private Button resetBtn;

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.sb01);
        progressBtn = findViewById(R.id.btnProgress);
        resetBtn = findViewById(R.id.btnReset);

        progressBtn.setOnClickListener(listener);
        resetBtn.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.btnProgress:
                    Toast.makeText(MainActivity.this, "Progress", Toast.LENGTH_LONG).show();
                    // 프로그레스 바와 바찬가지로 증가 값.
                    seekBar.incrementProgressBy(10);
                    seekBar.incrementSecondaryProgressBy(20);
                    break;

                case R.id.btnReset:
                    Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_LONG).show();
                    seekBar.setProgress(0);
                    seekBar.setSecondaryProgress(100);
                    break;
            }

        }
    };

}

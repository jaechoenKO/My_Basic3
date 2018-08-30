package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 하나의 객체에는 여러 개의 리스너를 등록할 수 있다.
 * **/
public class MainActivity extends AppCompatActivity {

    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = findViewById(R.id.rl01);

        rl.setOnLongClickListener(longClickListener);

        // inner class
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "onClick() 발생", Toast.LENGTH_LONG).show();
            }
        });

    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(getBaseContext(), "OnLongClick() 발생", Toast.LENGTH_LONG).show();
            return true;
        }
    };
}

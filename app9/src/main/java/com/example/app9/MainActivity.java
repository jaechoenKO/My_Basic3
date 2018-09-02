package com.example.app9;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv01);

    }

    // 알림 대화상자 생성
    private AlertDialog makeDialog(){

        // 대화상자를 생성하려면 Builder 객체를 생성 해야 한다.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 대화상자의 제목
        builder.setTitle("알림");
        // 대화상자의 메세지
        builder.setMessage("아무거나 선택");
        // 대화상자의 아이콘. 현재 코드는 안드로이드에서 기본으로 제공되는 아이콘
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // 대화상자의 버튼 설정
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Integer.toString(i) : 어떤 버튼이 눌렸는지 확인 가능.
                msg = "OK 버튼을 선택" + Integer.toString(i);
                textView.setText(msg);
            }
        });

        // No Button 설정
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                msg = "NO 버튼을 선택" + Integer.toString(i);
                textView.setText(msg);
            }
        });

        // CANCEL BUTTON 설정
        builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                msg = "CANCEL 버튼을 선택" + Integer.toString(i);
                textView.setText(msg);
            }
        });

        // 세팅 후 생성 과정이 필요하다. 이때 Builder class의 create() 메소드 호출하여 대화상자 생성.
        AlertDialog dialog = builder.create();
        return dialog;

    }

    // 만들어진 대화상자를 호출하는 클릭 메소드
    public void btnClicked(View view) {

        AlertDialog alertDialog = makeDialog();
        // 대화상자를 보여준다.
        alertDialog.show();

    }



}

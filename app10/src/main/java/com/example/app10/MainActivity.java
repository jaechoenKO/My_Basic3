package com.example.app10;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert;
    Button btn_custom;
    Button btn_progress;
    TextView txt;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alert = findViewById(R.id.btn01);
        btn_custom = findViewById(R.id.btn02);
        btn_progress = findViewById(R.id.btn03);
        txt = findViewById(R.id.txt01);

        btn_alert.setOnClickListener(listener);
        btn_custom.setOnClickListener(listener);
        btn_progress.setOnClickListener(listener);

    }

    /**
     * 클릭 이벤트 리스너
     * **/
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                // 기본 AlertDialog
                case R.id.btn01:
                    // builder로 객체를 만들지 않고 .으로 설정 할 수도 있다.
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("프로야구팀")
                            .setMessage("두산")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getBaseContext(), "YES", Toast.LENGTH_LONG).show();
                                    txt.setText("두산");
                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getBaseContext(), "NO", Toast.LENGTH_LONG).show();
                                    txt.setText("다시 선택");
                                }
                            })
                            .show();
                    break;
                case R.id.btn02:
                    /**
                     * custom 사용
                     * **/
                    // custom dialog를 사용하기 위해 infaltion을 해야한다. View에도 inflate가 있다.
                    LinearLayout linearLayout = (LinearLayout) View.inflate(MainActivity.this, R.layout.custom, null);
                    // cutom.xml에 있는 EditText의 아이디 값을 찾아 온다.
                    final EditText editText = linearLayout.findViewById(R.id.et01);

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("프로야구팀")
                            // custom에서 만든 뷰를 셋팅 해준다.
                            .setView(linearLayout)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                                    String winner = editText.getText().toString();
                                    txt.setText(winner);
                                }
                            })
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this, "CANCEL", Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();
                    break;

                // ProgressDialog
                case R.id.btn03:
                    progressDialog = new ProgressDialog(MainActivity.this);
                    // progressDialog style, int 형으로 정의, int style, STYLE_SPINNER : 원형, STYLE_HORIZONTAL : 막대 모양
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    // 프로그래스 다이어로그 아이콘 세팅
                    progressDialog.setIcon(android.R.drawable.ic_dialog_info);
                    // 타이틀 제목
                    progressDialog.setTitle("DownLoad...");
                    // 내용
                    progressDialog.setMessage("다운로드 중 ...");
                    progressDialog.show();
                    break;
                default:
                    break;

            }

        }
    };

}

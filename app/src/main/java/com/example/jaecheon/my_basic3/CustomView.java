package com.example.jaecheon.my_basic3;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View{

    private Context mContext;

    public CustomView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.GREEN);

    }

    /**
     * MotionEvent : customView에 대한 터치 이벤트 발생시 그에 대한 정보를 가지고 있는 파라미터
     * **/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        // 이벤트에 대한 정보를 얻어 온다.
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            // 화면을 터치하는 이벤트이면
            Toast.makeText(this.mContext, "모션 터치 이벤트", Toast.LENGTH_LONG).show();
            return true; // 액션이 맞으면 true 반환
        }

        return false; // 액션이 아니면 false 반환
    }
}

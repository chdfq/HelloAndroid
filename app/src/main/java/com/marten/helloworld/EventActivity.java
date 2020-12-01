package com.marten.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.marten.helloworld.util.ToastUtil;
import com.marten.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    private MyButton mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnMy = findViewById(R.id.btn_my);
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "----onTouch----");
                        break;
                }
                return false;
            }
        });
        //内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
//        //匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("匿名内部类", "Click");
//                ToastUtil.showMsg(EventActivity.this,"click...");
//            }
//        });
//        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
//        //通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "click...");
                break;
        }
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Log.d("内部类", "Click");
                    ToastUtil.showMsg(EventActivity.this, "click...");
                    break;
            }
        }
    }
    //通过布局文件中onClick属性
    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Log.d("通过布局", "Click");
                ToastUtil.showMsg(EventActivity.this, "click...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "----onTouchEvent----");
                break;
        }
        return false;
    }
}
package com.marten.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class ViewAnimatorActivity extends AppCompatActivity {

    private Button mBtnStart;
    private ImageView mIvSmile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator);
        mBtnStart = findViewById(R.id.btn_start);
        mIvSmile = findViewById(R.id.iv_smile);
        //TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        //设置坐标
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,200);
        //设置停留在结束位置
        translateAnimation.setFillAfter(true);
        //设置执行时间，毫秒
        translateAnimation.setDuration(2000);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSmile.startAnimation(translateAnimation);
            }
        });
    }
}
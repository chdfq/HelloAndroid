package com.marten.helloworld;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private TextView tvTest;
    private ImageView mIvFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        mIvFrame = findViewById(R.id.iv_frame);
        tvTest = findViewById(R.id.tv);
//        tvTest.animate().translationYBy(500).setDuration(2000).start(); //沿Y轴平移 translationY到目的地
//        tvTest.animate().alpha(0).setDuration(2000).start(); //alpha渐变

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //0-100 valueAnimator实际的值
//                Log.d("animator", animation.getAnimatedValue() + "");
//                //0-1.0 动画的进度
//                Log.d("animator", animation.getAnimatedFraction() + "");
//            }
//        });
//        valueAnimator.start();

        //第二个参数translationX translationY alpha rotation rotationX...
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500, 200, 800);
        objectAnimator.setDuration(2000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        objectAnimator.start();

        //逐帧动画
        AnimationDrawable animationDrawable = (AnimationDrawable) mIvFrame.getBackground();
        animationDrawable.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.stop();
            }
        },3000);
    }
}
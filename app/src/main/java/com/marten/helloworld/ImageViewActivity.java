package com.marten.helloworld;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = findViewById(R.id.iv_4);
        Glide.with(this).load("https://c-ssl.duitang.com/uploads/item/202002/04/20200204154029_ucizy.jpg").into(mIv4);
    }
}
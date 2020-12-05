package com.marten.helloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.marten.helloworld.R;

public class BroadActivity extends AppCompatActivity {

    private Button mBtn1;
    private TextView mTvTest;
    private MyBroadcast mBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
        mBtn1 = findViewById(R.id.btn1);
        mTvTest = findViewById(R.id.tv_test);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this, BroadActivity2.class);
                startActivity(intent);
                //startActivityForResult();
            }
        });

        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.marten.update");
        //intentFilter.addAction("xxx");
        LocalBroadcastManager.getInstance(BroadActivity.this).registerReceiver(mBroadcast, intentFilter);   //注册广播接收器registerReceiver(BroadcastReceiver, IntentFilter)
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    private class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) { //重写onReceive
            switch (intent.getAction()) {
                case "com.marten.update":
                    mTvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏 unregisterReceiver(BroadcastReceiver)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }
}
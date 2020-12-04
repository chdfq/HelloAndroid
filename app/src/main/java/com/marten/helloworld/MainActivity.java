package com.marten.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.marten.helloworld.datastorage.DataStorageActivity;
import com.marten.helloworld.fragment.ContainerActivity;

import jump.AActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;
    private Button mBtnEvent;
    private Button mBtnObjAnimator;
    private Button mBtnViewAnimator;
    private Button mBtnData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnObjAnimator = findViewById(R.id.btn_obj_animator);
        mBtnViewAnimator = findViewById(R.id.btn_view_animator);
        mBtnData = findViewById(R.id.btn_data);

        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnObjAnimator.setOnClickListener(onClick);
        mBtnViewAnimator.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_obj_animator:
                    intent = new Intent(MainActivity.this, ObjectAnimatorActivity.class);
                    break;
                case R.id.btn_view_animator:
                    intent = new Intent(MainActivity.this, ViewAnimatorActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
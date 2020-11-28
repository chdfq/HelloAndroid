package com.marten.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonAndSwitchActivity extends AppCompatActivity {

    private ToggleButton mTb1;
    private Switch mSw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_and_switch);
        mTb1 = findViewById(R.id.tb_1);
        mTb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ToggleButtonAndSwitchActivity.this,isChecked?"togglebutton On":"togglebutton Off",Toast.LENGTH_SHORT).show();
            }
        });

        mSw1 = findViewById(R.id.sw_1);
        mSw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ToggleButtonAndSwitchActivity.this,isChecked?"switch On":"switch Off",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
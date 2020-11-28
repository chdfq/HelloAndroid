package jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.marten.helloworld.R;
import com.marten.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump, mBtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("ALaunchMode", "----onCreate----");
        Log.d("ALaunchMode", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logTaskName();
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnJump2 = findViewById(R.id.btn_jump_2);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "intent通过bundle在传递数据");
                bundle.putInt("number", 88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent, 0);

                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"jump.BActivity");
//                startActivity(intent);

                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,BActivity.class));
//                startActivity(intent);

                //隐式
//                Intent intent = new Intent();
//                intent.setAction("com.marten.test.BActivity");
//                startActivity(intent);
            }
        });
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    ToastUtil.showMsg(this, data.getExtras().getString("title"));
                }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("ALaunchMode", "----onANewIntent----");
        Log.d("ALaunchMode", "taskid:" + getTaskId() + " ,hash:" + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("ALaunchMode", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
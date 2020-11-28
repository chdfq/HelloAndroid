package jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.marten.helloworld.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Button mBtnFinish, mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BLaunchMode","----onCreate----");
        Log.d("BLaunchMode","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logTaskName();
        mTvTitle = findViewById(R.id.tv_title);
        mBtnFinish = findViewById(R.id.btn_finish);
        mBtn2 = findViewById(R.id.btn_2);
        Bundle bundle = getIntent().getExtras();
        mTvTitle.setText(bundle.getString("name") + "," + bundle.getInt("number"));
        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BLaunchMode","----onBNewIntent----");
        Log.d("BLaunchMode","taskid:"+getTaskId()+" ,hash:"+hashCode());
        logTaskName();
    }

    private void logTaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BLaunchMode",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

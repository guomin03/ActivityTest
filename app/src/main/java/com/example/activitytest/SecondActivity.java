package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is "+getTaskId());
        setContentView(R.layout.activity_second);
        //获取活动传递过来的数据
        /*Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity:",data);*/

        //按钮注册点击事件
        Button btn2 =  (Button) findViewById(R.id.button_2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);

//                intent.putExtra("data_return","加油呀！目标就再前方");
//                setResult(RESULT_OK,intent);
//               intent finish();

            }
        });





    }

    /**
     * 当用户按下返回键，执行onBackPressed(),返回数据
     */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return","哈哈，是我！！！");
        setResult(RESULT_OK,intent);
        finish();
    }

}

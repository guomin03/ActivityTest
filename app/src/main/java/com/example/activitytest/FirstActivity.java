package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId());
        //加载布局(first_layout)
        setContentView(R.layout.first_layout);
        /**
         * 在活动中使用Toast
         * Toast 是Android系统提供的一种非常好的提醒方式，
         * 在程序中可以使用它将一些短小的信息通知给用户
         */
        Button  btn1 = (Button)findViewById(R.id.button_1);//得到活动中的id
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();

   /*    Intent的显示和隐式用法：
                //Intent显示用法
// Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //隐式Intent用法
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //添加一个Intent
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //启动Intent
                startActivity(intent);
                */
   //隐式Intent来打开网页
//                Intent  intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);

                //调用系统拨号界面
               /* Intent intent  = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

               //向下一个活动传递数据
                /*String data = "我来了，准备好吃的了吗？";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                //返回数据给上一个活动
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);


               /* Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);*/

                SecondActivity.actionStart(FirstActivity.this,"data1","data2");


            }



        });
    }



    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity:",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main, menu);

//        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return  true;
    }




}

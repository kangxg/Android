package com.example.kangxg.handroid2test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by kangxg on 2017/10/27.
 */

public class NextActivity extends  Activity{

    private Button closeButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        closeButton = (Button)findViewById(R.id.closeButton);
        //    my_button2.setText("@string/close");    //setText里面不能采用资源引用
        //资源引用显示文本应该是在xml中的
        //my_button2.setText("Close");

        closeButton.setOnClickListener(new NextActivity.CloseButtonListener());
    }

    class CloseButtonListener implements View.OnClickListener {
        public void onClick(View v) {
            // 返回上一页
            finish();

        }
    }
}

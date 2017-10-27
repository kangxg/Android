package com.example.kangxg.handroid2test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import android.app.Activity;
import android.content.Intent;
import android.view.View;//注意view的大小写
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button nextbutton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView tv_hello = (TextView )findViewById(R.id.tv_hello);

        tv_hello.setText("今天我来的比较早，给自己一个鼓励！");
        tv_hello.setTextColor(Color.RED);
        tv_hello.setTextSize(30);

        nextbutton = (Button)findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(new NextButtonListener());

    }
    class NextButtonListener implements OnClickListener {
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, NextActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
}

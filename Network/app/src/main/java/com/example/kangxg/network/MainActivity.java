package com.example.kangxg.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private static final String TAG = "TActivity";
    private EditText    imageEditText;
    private ImageView   imageView;
    private  AsyncLoadHandler     handler  = new AsyncLoadHandler() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageEditText = (EditText)findViewById(R.id.path);
        imageView     = (ImageView)findViewById(R.id.TImageView);

        Button button = (Button)findViewById(R.id.TButton);
        button.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v)
    {
        // 定义后台下载线程
        new Thread(new MyThread()).start();

    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            Bitmap bitmap = null;
            String path = imageEditText.getText().toString();
            try {
               //URL url = new URL(path);//创建Url对象
               //InputStream inputStream = url.openStream();
                //bitmap = BitmapFactory.decodeStream(inputStream);

                byte[] data = NetTool.getImage(path);
                bitmap = BitmapFactory.decodeByteArray(data,0,data.length);

            } catch (Exception e) {

                e.printStackTrace();
                Log.i(TAG,e.getMessage());
                Toast.makeText(MainActivity.this,"获取图片失败",1).show();
            }
			//创建Message对象，返回信息
            Message message = Message.obtain();
            message.obj = bitmap;
            message.what = 1;
            handler.sendMessage(message);
        }

    }

    // 图片下载完成通知主线程显示图片
    public class AsyncLoadHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                imageView.setImageBitmap(bitmap);

            }
        }
    }

}

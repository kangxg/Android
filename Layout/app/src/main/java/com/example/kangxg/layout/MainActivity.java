package com.example.kangxg.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;



import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;


public class MainActivity extends AppCompatActivity   implements OnClickListener {
    private RelativeLayout rl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_content =  (RelativeLayout)findViewById(R.id.rl_content);

        Button centerbtn = (Button)findViewById(R.id.btn_center);
        centerbtn.setOnClickListener(this);

        Button hcenterbtn = (Button)findViewById(R.id.btn_center_horizontal);
        hcenterbtn.setOnClickListener(this);

        Button vcenterbtn = (Button)findViewById(R.id.btn_centerVertival);
        vcenterbtn.setOnClickListener(this);

        Button lcenterbtn = (Button)findViewById(R.id.btn_parent_left);
        lcenterbtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.btn_center)
        {
            addNewView(RelativeLayout.CENTER_IN_PARENT,-1,rl_content.getId());
        }
        else if (v.getId() ==  R.id.btn_center_horizontal)
        {

        }
        else if (v.getId() ==  R.id.btn_centerVertival)
        {

        }
        else if (v.getId() == R.id.btn_parent_left)
        {
            addNewView(RelativeLayout.LEFT_OF,RelativeLayout.ALIGN_TOP,v.getId());
        }
    }
    private void addNewView(int firstAlign,int SencondAlign,int referId)
    {
        View v = new View(this);
        v.setBackgroundColor(0xaa66ff66);

        RelativeLayout.LayoutParams rl_params = new RelativeLayout.LayoutParams(100,100);

        rl_params.addRule(firstAlign,referId);
        if (SencondAlign>=0)
        {
            rl_params.addRule(SencondAlign,referId);
        }
        v.setLayoutParams(rl_params);


        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
              rl_content.removeView(view);
              return  true;
            }
        });
//        rl_content.addView(v,rl_params);
        addContentView(v,rl_params);


//        addContentView(v,rl_params);
//      rl_content.addView(v);
      //必须加这个否则不显示

    }


}

package com.example.fontcolor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;


public class MainActivity extends Activity {

    int idx=0;
    TextView tv;
    EditText ed;
    int colorVals[]={R.color.start,R.color.mid,R.color.last};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.modtext);
        ed=(EditText)findViewById(R.id.edtext);

        Button chf=(Button) findViewById(R.id.change);
        chf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                tv.setTextColor(getResources().getColor(colorVals[idx]));
                idx=(idx+1)%3;
            }
        });

        Button mvb=(Button) findViewById(R.id.move);
        mvb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String str=ed.getText().toString();
                tv.setText(str);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
package com.example.database;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.List;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;;

public class MainActivity extends Activity {

    public EditText  editorE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.close);
        editorE=(EditText)findViewById(R.id.editor);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });



        final DatabaseHandler db = new DatabaseHandler(this);

        Button but1 = (Button) findViewById(R.id.insert);

        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Inserting known Languages
                //Log.d("Insert: ", "Inserting ..");
                db.add(new values("man"));
                db.add(new values("frau"));
                db.add(new values("younger"));
                db.add(new values("madchen"));

                String str="DataBase successfully created!!!!";
                StringBuilder buf=new StringBuilder();


                buf.append(str+"\n");



                editorE.setText(buf.toString());

                // editorE.setText("DataBase Successfully Updated");
            }
        });

        Button but2 = (Button) findViewById(R.id.Read);

        but2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Reading data Already present in the Database
                Log.d("Reading: ", "Reading all data..");
                List<values> val = db.getAllvalues();
                String str="";
                StringBuilder buf=new StringBuilder();


                for (values cn : val) {
                    str = "Id: " + cn.getId() + " ,values: "
                            + cn.getValue();
                    buf.append(str+"\n");
                }

                editorE.setText(buf.toString());
            }
        });

        Button chf=(Button) findViewById(R.id.change);
        chf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

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

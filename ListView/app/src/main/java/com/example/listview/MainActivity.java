package com.example.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.webkit.*;

public class MainActivity extends Activity {

    ListView listView ;
    private ImageView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wv1=(ImageView)findViewById(R.id.imageView1);

        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] valuesq = new String[] {"Нюша",
                "Лосяш",
                "Крош",
                "Кар-Карыч",
                "Пин",
                "Ёжик",
                "Совунья",
                "Бараш"
        };


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, valuesq);
        final  Animation anim=AnimationUtils.loadAnimation(this, R.anim.rotate);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        //listView.setOnItemClickListener(new OnItemClickListener() {

        listView.setOnItemClickListener(new OnItemClickListener(){

            @Override



            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                // ListView Clicked item index
                int itemPosition     = arg2; //position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(arg2/*position*/);

                switch(itemPosition)
                {
                    case 0:
                        itemValue="image1";
                        wv1.setImageResource(R.drawable.image1);
                        wv1.startAnimation(anim);
                        break;

                    case 1:
                        itemValue="image2";
                        wv1.setImageResource(R.drawable.image2);
                        wv1.startAnimation(anim);
                        break;

                    case 2:
                        itemValue="image3";
                        wv1.setImageResource(R.drawable.image3);
                        wv1.startAnimation(anim);
                        break;
                    case 3:
                        itemValue="image4";
                        wv1.setImageResource(R.drawable.image4);
                        wv1.startAnimation(anim);
                        break;
                    case 4:
                        itemValue="image5";
                        wv1.setImageResource(R.drawable.image5);
                        wv1.startAnimation(anim);
                        break;
                    case 5:
                        itemValue="image6";
                        wv1.setImageResource(R.drawable.image6);
                        wv1.startAnimation(anim);
                        break;
                    case 6:
                        itemValue="image7";
                        wv1.setImageResource(R.drawable.image7);
                        wv1.startAnimation(anim);
                        break;
                    case 7:
                        itemValue="image8";
                        wv1.setImageResource(R.drawable.image8);
                        wv1.startAnimation(anim);
                        break;

                }

                Toast.makeText(getApplicationContext(),
                                "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }

        });
    }

}

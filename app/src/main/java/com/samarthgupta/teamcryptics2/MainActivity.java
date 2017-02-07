package com.samarthgupta.teamcryptics2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> newList = new ArrayList<String>();
        ImageButton ib1;
        EditText et1;
        ListView lv1;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lv1 = (ListView)findViewById(R.id.listView);
             ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , newList);
            lv1.setAdapter(myAdapter);

            et1=(EditText)findViewById(R.id.editText);
            ib1=(ImageButton)findViewById(R.id.imageButton);

            ib1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String t=et1.getText().toString();
                    FireClass fireClass = new FireClass();
                    newList = fireClass.getList(t);
                    et1.setText("");
                }
            });

    }


    /*
    void click(){

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=et1.getText().toString();
                goToTop(t);
                Log.i("TAG","1st click");
                if (t.matches("1")){
                    new FireClass(); //Calling constructor
                }
                ib1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String t1=et1.getText().toString();
                        goToTop(t1);
                        new FireClass(t1);   //Calling constructor
                        Log.i("TAG","2st click");

                        ib1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                final String t2=et1.getText().toString();
                                goToTop(t2);
                                Log.i("TAG","3st click");
                                final FireClass fireClass1 = new FireClass(t1,t2); //Calling constructor

                            ib1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String t3= et1.getText().toString();
                                    goToTop(t3);
                                    Log.i("TAG","4st click");
                                    fireClass1.getVal(t1,t2,t3); //Calling function
                                }
                            });

                            }
                        });
                    }
                });
            }
        });
    } //End of click function

    //Function for going to the top of click
    void goToTop(String x){
        if (x.matches("X")){
            click();
        }
    }
*/

}


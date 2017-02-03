package com.samarthgupta.teamcryptics2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


        ImageButton ib1;
        EditText et1;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            et1=(EditText)findViewById(R.id.editText);
            ib1=(ImageButton)findViewById(R.id.imageButton);
            click();

    }


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


}


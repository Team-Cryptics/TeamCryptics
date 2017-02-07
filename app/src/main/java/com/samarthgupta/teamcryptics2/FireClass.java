gtpackage com.samarthgupta.teamcryptics2;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by samarthgupta on 04/02/17.
 */

    public class FireClass extends MainActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref = firebaseDatabase.getReference();


    public FireClass(final String where) {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.child(where).getChildren()) {
                    Log.i("TAG", dsp.getKey().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}

    /*
    public FireClass(){

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()){
                    Log.i("TAG",dsp.getKey().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public FireClass(final String where1, final String where2){

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.child(where1).child(where2).getChildren()){
                    Log.i("TAG",dsp.getKey().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    void getVal(final String where1, final String where2, final String where3){
        //THIS GIVES THE VALUE
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String val = dataSnapshot.child(where1).child(where2).child(where3).getValue().toString();
                Log.i("TAG",val);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    } */







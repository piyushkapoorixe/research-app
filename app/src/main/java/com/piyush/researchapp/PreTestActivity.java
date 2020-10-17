package com.piyush.researchapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PreTestActivity extends AppCompatActivity {
    Button submit_pre_test_Btn;
    DatabaseReference rootRef, emailRef;
    Map<String, Object> updates = new HashMap<String,Object>();
    String mAccountUserId;
    String pretest;
    String email;
    Intent intent;
    //Map<String, Object> updates2 = new HashMap<String,Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_test);
        intent = getIntent();
        mAccountUserId = intent.getStringExtra("mAccountUserId");
        pretest = intent.getStringExtra("pretest");
        email = intent.getStringExtra("email");
        submit_pre_test_Btn = findViewById(R.id.submit_pre_test_Btn);

        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        // Database reference pointing to demo node
        emailRef = rootRef.child("data");

        submit_pre_test_Btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = intent.getStringExtra("email");
                //Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();
                // Push creates a unique id in database
                /*updates.put("email", email);
                updates.put("marks", "10");
//                emailRef.push().setValue(updates);
                rootRef.child("data").child(userId).setValue(updates);*/
                ResearchData data = new ResearchData(mAccountUserId,email,50,"1");
                rootRef.child(mAccountUserId).setValue(data);
                gotoContent1Activity();
            }
        }));

        /*rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    ResearchData data = snapshot.child(mAccountUserId).getValue(ResearchData.class);
                    pretest = data.getPretest();
                    if (data!=null) {
                        if (data.getMarks() > 10) {
                            Toast.makeText(PreTestActivity.this, "marks greater than 10", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PreTestActivity.this, "10", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });*/
    }



    private void gotoContent1Activity(){
        Intent intent=new Intent(this,Content1Activity.class);
        intent.putExtra("email", email);
        intent.putExtra("mAccountUserId",mAccountUserId);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Disabled Back Press", Toast.LENGTH_SHORT).show();
    }
}
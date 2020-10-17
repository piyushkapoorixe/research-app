package com.piyush.researchapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Content3Activity extends AppCompatActivity {
    Button content3_Btn;
    String email;
    String mAccountUserId;
    Intent intent;
    DatabaseReference rootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content3);
        intent = getIntent();
        mAccountUserId = intent.getStringExtra("mAccountUserId");
        email = intent.getStringExtra("email");

        content3_Btn = findViewById(R.id.content2_Btn);

        rootRef = FirebaseDatabase.getInstance().getReference();

        content3_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //gotoPostTestActivity();

                rootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //if (snapshot.exists()) {
                        ResearchData data = snapshot.child(mAccountUserId).getValue(ResearchData.class);
                        if (data!=null) {
                            if (!data.getPosttest()) {
                                //Toast.makeText(ProfileActivity.this, "marks greater than 10", Toast.LENGTH_SHORT).show();
                                gotoPostTestActivity();
                            } else if (data.getPosttest()) {
                                //Toast.makeText(ProfileActivity.this, "10", Toast.LENGTH_SHORT).show();
                                gotoProfileActivity();
                            }
                        } else {
                            gotoProfileActivity();
                        }
                        //}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });

                ResearchData data = new ResearchData( true, mAccountUserId);
                rootRef.child(mAccountUserId).setValue(data);
            }
        });
    }

    private void gotoPostTestActivity() {
        Intent intent=new Intent(this,PostTestActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("mAccountUserId", mAccountUserId);
        startActivity(intent);
    }

    private void gotoProfileActivity() {
        Intent intent=new Intent(this,ProfileActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("mAccountUserId", mAccountUserId);
        startActivity(intent);
    }
}
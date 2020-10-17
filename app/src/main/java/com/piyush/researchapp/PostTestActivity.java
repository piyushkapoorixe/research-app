package com.piyush.researchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostTestActivity extends AppCompatActivity {
    Button submit_post_test_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_test);

        submit_post_test_Btn = findViewById(R.id.submit_post_test_Btn);

        submit_post_test_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoContent1Activity();
            }
        });
    }

    private void gotoContent1Activity(){
        Intent intent=new Intent(this,Content1Activity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Disabled Back Press", Toast.LENGTH_SHORT).show();
    }
}
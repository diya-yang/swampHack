package com.example.swamphack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ForgetPasswordAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        Button forgetDonebtn = (Button) findViewById(R.id.Donebtn);
        forgetDonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ForgetPasswordAcitivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
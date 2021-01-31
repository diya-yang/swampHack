package com.example.swamphack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //after sign up, click I'm Done to go back to the login page
        Button signupDonebtn = (Button) findViewById(R.id.signBtn);
        signupDonebtn.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View v) {
               Intent intent = new Intent(SignUpAcitivity.this, LoginAcitivity.class);
              startActivity(intent);
            }
        });
    }
}


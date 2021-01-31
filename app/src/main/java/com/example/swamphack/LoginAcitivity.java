package com.example.swamphack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginAcitivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //click sign-up and go to sign up page
        Button signUp_button = (Button) findViewById(R.id.signUp_button);
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAcitivity.this, SignUpAcitivity.class);
                startActivity(intent);
            }
        });

        Button forget_button = (Button) findViewById(R.id.forget_button);
        forget_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAcitivity.this, ForgetPasswordAcitivity.class);
                startActivity(intent);
            }
        });


        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginAcitivity.this,MatchAcitivity.class);
                startActivity(intent);
            }
        });

    }
}
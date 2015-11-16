package com.example.jomunjeong.hello;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");

    }

    public void onButton1Clicked(View v){

        if(usernameWrapper != null && passwordWrapper != null){

            Toast.makeText(getApplicationContext(), usernameWrapper.getEditText().getText().toString() + "/" + passwordWrapper.getEditText().getText().toString(), Toast.LENGTH_LONG).show();


        }



    }
}

package com.karmug.helpme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSucess extends AppCompatActivity
{

    private Button registerBtn, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sucess);
        logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(Login.getIsLoggedIn())
                {
                    Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginSucess.this,MainActivity.class));
                    Login.setIsLoggedIn(false);
                    finish();
                }
            }
        });
    }
}


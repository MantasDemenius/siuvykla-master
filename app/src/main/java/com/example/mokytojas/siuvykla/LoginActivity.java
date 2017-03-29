package com.example.mokytojas.siuvykla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button login_button;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //kreipimasis i paveldimos klases metoda
        setContentView(R.layout.activity_login); //susiejame xml su kodu

    LoginButton();

        RegisterButton();
    }

    public void LoginButton() {
        login_button = (Button) findViewById(R.id.logino_mygtukas);

        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(LoginActivity.this, MeniuActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                LoginActivity.this.startActivity(myIntent);

            }

        });
    }

    public void RegisterButton() {
        register_button = (Button) findViewById(R.id.registracijos_mygtukas);

        register_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                LoginActivity.this.startActivity(myIntent);

            }

        });
    }
}

package com.example.mokytojas.siuvykla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity {

    private Button login_button, register_button;
    private EditText login_text, password_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //kreipimasis i paveldimos klases metoda
        setContentView(R.layout.activity_login); //susiejame xml su kodu


        RegisterButton();
        Authentication();

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

    public void Authentication() {

        login_button = (Button)findViewById(R.id.logino_mygtukas);
        login_text = (EditText)findViewById(R.id.prisijungimo_vardas);
        password_text = (EditText)findViewById(R.id.prisijungimo_slaptazodis);

        login_text.setError(null);
        password_text.setError(null);



        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = login_text.getText().toString();
                String password = password_text.getText().toString();

               /* Toast.makeText(getApplicationContext(),
                        "username:"+username+"\n"+
                        "password:"+password, Toast.LENGTH_SHORT).show();*/

                boolean cancel = false;
                View focusView = null;

                if (!IsValid(username)) {

                    login_text.setError(getString(R.string.login_invalid_username));
                    focusView = login_text;
                    cancel = true;
                }

                if (!IsValid(password)) {
                    password_text.setError(getString(R.string.login_invalid_password));
                    focusView = password_text;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {
                    Intent myIntent = new Intent(LoginActivity.this, MeniuActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    LoginActivity.this.startActivity(myIntent);
                }

                /*if (login_text.getText().toString().equals("admin") &&
                        password_text.getText().toString().equals("yourmom")) {
                    Toast.makeText(getApplicationContext(),
                            "Palauk...", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(LoginActivity.this, MeniuActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    LoginActivity.this.startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Neteisingai", Toast.LENGTH_SHORT).show();
                }*/

            }


        });
    }

    private boolean IsValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^([0-9a-zA-Z]{3,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher (credentials);
        return matcher.matches();
    }

}


package com.example.mokytojas.siuvykla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity {

    Button sign_up_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signUpButton();
    }

    public void signUpButton() {
        sign_up_button = (Button) findViewById(R.id.sign_up_button);

        sign_up_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                RegisterActivity.this.startActivity(myIntent);

            }

        });
    }
}

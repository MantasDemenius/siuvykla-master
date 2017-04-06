package com.example.mokytojas.siuvykla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity {

    Button sign_up_button;
    private EditText register_username, register_password, register_re_password, register_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signUpButton();
    }

    public void signUpButton() {

        register_username = (EditText) findViewById(R.id.register_new_username);
        register_password = (EditText) findViewById(R.id.register_new_password);
        register_re_password = (EditText) findViewById(R.id.register_repeat_password);
        register_email = (EditText) findViewById(R.id.register_email);
        sign_up_button = (Button) findViewById(R.id.sign_up_button);

        register_username.setError(null);
        register_password.setError(null);
        register_re_password.setError(null);
        register_email.setError(null);

        sign_up_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String txt_username = register_username.getText().toString();
                String txt_password = register_password.getText().toString();
                String txt_re_password = register_re_password.getText().toString();
                String txt_email = register_email.getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (!IsValid(txt_username)) {

                    register_username.setError(getString(R.string.login_invalid_username));
                    focusView = register_username;
                    cancel = true;
                }

                if (!IsValid(txt_password)) {
                    register_password.setError(getString(R.string.login_invalid_password));
                    focusView = register_password;
                    cancel = true;
                }

                if (!IsValid(txt_re_password)) {
                    register_re_password.setError(getString(R.string.login_invalid_password));
                    focusView = register_re_password;
                    cancel = true;
                }

                if (!IsEmailValid(txt_email)) {
                    register_email.setError(getString(R.string.register_invalid_email));
                    focusView = register_email;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {
                    Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    RegisterActivity.this.startActivity(myIntent);
                }

            }

        });
    }

    private boolean IsValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^([0-9a-zA-Z]{3,15})+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher (credentials);
        return matcher.matches();
    }

    public static boolean IsEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}

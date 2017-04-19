package com.example.mokytojas.siuvykla;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends Activity {


    private static final String REGISTER_URL = "http://venslovaitis.byethost10.com/App-siuvykla/register1.php";



    Button sign_up_button;
    private EditText register_username, register_password, register_re_password, register_email;
    private Registracija user;


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

                String txt_username = register_username.getText().toString().trim().toLowerCase();
                String txt_password = register_password.getText().toString().trim();
                String txt_re_password = register_re_password.getText().toString().trim();
                String txt_email = register_email.getText().toString().trim().toLowerCase();

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

                if (!IsEmailValid(txt_email)) {
                    register_email.setError(getString(R.string.register_invalid_email));
                    focusView = register_email;
                    cancel = true;
                }

                if (!txt_password.equals(txt_re_password)) {

                    register_re_password.setError(getString(R.string.register_password_re_error));
                    focusView = register_re_password;
                    cancel = true;
                }

                if (cancel) {
                    focusView.requestFocus();
                } else {

                    user = new Registracija(txt_username, txt_password, txt_email);

                    userRegistration(user);

                    /*Toast.makeText(RegisterActivity.this,
                            "objekte: "+
                                    "\nVartotojo vardas : " + user.getUsername()+
                                    "\nPasswordas : " + user.getPassword() +
                                    "\nEmailas : " + user.getEmail(),
                            Toast.LENGTH_LONG).show();*/

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

        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }

    private boolean IsEmailValid(String email) {
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

    private void userRegistration(final Registracija user) {

        //register
        String urlSuffix = "?username="+user.getUsername()+"&password="+user.getPassword()+"&email="+user.getEmail();
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestProperty("Cookie", "__test=7a4d917e220fbf9a55cab3046bd1a3b7; expires=2038 m. sausio 1 d., penktadienis 01:55:55; path=/");
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                } catch (Exception e) {
                    return null;
                }
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }
}

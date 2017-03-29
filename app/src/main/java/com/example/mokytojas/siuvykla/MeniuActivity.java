package com.example.mokytojas.siuvykla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeniuActivity extends AppCompatActivity {

    Button new_post_button;
    Button search_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);

        newPostButton();
        searchButton();

    }
    public void newPostButton() {
        new_post_button = (Button) findViewById(R.id.naujas_irasas);

        new_post_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(MeniuActivity.this, New_post.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MeniuActivity.this.startActivity(myIntent);

            }

        });
    }

    public void searchButton() {
        search_button = (Button) findViewById(R.id.paieska);

        search_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent myIntent = new Intent(MeniuActivity.this, Search.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MeniuActivity.this.startActivity(myIntent);

            }

        });
    }
}

package com.example.mokytojas.siuvykla;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;



public class New_post extends Activity {

    private Spinner clothes_type, gender, color, delivery;
    private Button submit_button;
    private EditText order, price, clothes_lenght, clothes_width;
    private String order_text, price_text, clothes_lenght_text, clothes_width_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

      //  addItemsOnClothes();
        SubmitButton();
       // addListenerOnSpinnerItemSelection();
    }

    public void SubmitButton() {

        clothes_type = (Spinner) findViewById(R.id.clothes_type);
        gender = (Spinner) findViewById(R.id.gender);
        color = (Spinner) findViewById(R.id.color);
        delivery = (Spinner) findViewById(R.id.delivery);
        submit_button = (Button) findViewById(R.id.operation_one_submit);
        order = (EditText) findViewById(R.id.order);
        price = (EditText) findViewById(R.id.price);
        clothes_lenght = (EditText) findViewById(R.id.clothes_lenght);
        clothes_width = (EditText) findViewById(R.id.clothes_width);

        order_text = order.getText().toString();
        price_text = price.getText().toString();
        clothes_lenght_text = clothes_lenght.getText().toString();
        clothes_width_text = clothes_lenght.getText().toString();

        order.setError(null);
        price.setError(null);
        clothes_lenght.setError(null);
        clothes_width.setError(null);


        submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            boolean cancel = false;
                if (TextUtils.isEmpty(order_text)) {
                    order.setError(getString(R.string.operation_one_error));
                } else if (TextUtils.isEmpty(price_text)) {
                    price.setError(getString(R.string.operation_one_error));
                } else if (TextUtils.isEmpty(clothes_lenght_text)){
                    clothes_lenght.setError(getString(R.string.operation_one_error));
                } else if (TextUtils.isEmpty(clothes_width_text)) {
                    clothes_width.setError(getString(R.string.operation_one_error));
                }else {
                    Toast.makeText(New_post.this,
                            "Jūsų užsakymas: " +
                                    "\nDrabužio tipas : " + String.valueOf(clothes_type.getSelectedItem()) +
                                    "\nUžsakymų kiekis : " + String.valueOf(order.getText()) +
                                    "\nLytis : " + String.valueOf(gender.getSelectedItem()) +
                                    "\nKaina : " + String.valueOf(price.getText()) +
                                    "\nSpalva : " + String.valueOf(color.getSelectedItem()) +
                                    "\nDrabužio ilgis : " + String.valueOf(clothes_lenght.getText()) +
                                    "\nDrabužio plotis : " + String.valueOf(clothes_width.getText()) +
                                    "\nPristatymas : " + String.valueOf(delivery.getSelectedItem()),
                            Toast.LENGTH_SHORT).show();
                    cancel = true;
                }

                if (cancel) {
                    Intent myIntent = new Intent(New_post.this, MeniuActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    New_post.this.startActivity(myIntent);
                }


            }

        });
    }

}




/* public void addItemsOnClothes(){ without string arrays

        clothes_type = (Spinner) findViewById(R.id.clothes_type);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothes_type.setAdapter(dataAdapter);
    }*/

    /*public void addListenerOnSpinnerItemSelection() {
        gender = (Spinner) findViewById(R.id.gender);
        gender.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }*/
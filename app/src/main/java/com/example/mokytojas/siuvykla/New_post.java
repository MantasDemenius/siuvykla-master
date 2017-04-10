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
    private EditText order, price, clothes_length, clothes_width;

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
        clothes_length = (EditText) findViewById(R.id.clothes_length);
        clothes_width = (EditText) findViewById(R.id.clothes_width);

        order.setError(null);
        price.setError(null);
        clothes_length.setError(null);
        clothes_width.setError(null);

        submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String order_text = order.getText().toString();
                String price_text = price.getText().toString();
                String clothes_length_text = clothes_length.getText().toString();
                String clothes_width_text = clothes_width.getText().toString();


            boolean cancel = false;
            boolean show = true;
                if (TextUtils.isEmpty(order_text)) {
                    order.setError(getString(R.string.operation_one_error));
                    show = false;
                }
                if (TextUtils.isEmpty(price_text)) {
                    price.setError(getString(R.string.operation_one_error));
                    show = false;
                }
                if (TextUtils.isEmpty(clothes_length_text)){
                    clothes_length.setError(getString(R.string.operation_one_error));
                    show = false;
                }
                if (TextUtils.isEmpty(clothes_width_text)) {
                    clothes_width.setError(getString(R.string.operation_one_error));
                    show = false;
                }

                if (show) {

                    double order_num = Double.parseDouble(order_text);
                    double price_num = Double.parseDouble(price_text);
                    double clothes_length_num = Double.parseDouble(clothes_length_text);
                    double clothes_width_num = Double.parseDouble(clothes_width_text);

                    Drabuzis cl = new Drabuzis(String.valueOf(clothes_type.getSelectedItem()), String.valueOf(gender.getSelectedItem()), String.valueOf(color.getSelectedItem()), String.valueOf(delivery.getSelectedItem()), order_num, price_num, clothes_length_num, clothes_width_num);

                    Toast.makeText(New_post.this,
                            "objekte: "+
                                    "\nDrabužio tipas : " + cl.getType()+
                                    "\nLytis : " + cl.getGender() +
                                    "\nSpalva : " + cl.getColor() +
                                    "\nPristatymas : " + cl.getDelivery() +
                                    "\nUžsakymų kiekis : " + cl.getOrder() +
                                    "\nKaina : " + cl.getPrice() +
                                    "\nDrabužio ilgis : " + cl.getLength() +
                                    "\nDrabužio plotis : " + cl.getWidth(),
                            Toast.LENGTH_LONG).show();



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
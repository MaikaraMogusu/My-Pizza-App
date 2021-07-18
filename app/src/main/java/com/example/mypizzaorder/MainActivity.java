package com.example.mypizzaorder;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    pizza pizza;
    TextView total;
    double total_price;
    TextView delivery;
    Button getRating;
    TextView FinalPage;
    TextView go_drinks_menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizza=new pizza();
        total= (TextView) findViewById(R.id.total);
        delivery=findViewById(R.id.deliveryNote);
        getRating=findViewById(R.id.getRating);
        final RatingBar ratingBar=findViewById(R.id.ratingBar);

        getRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating="Rating is :" +ratingBar.getRating();
                Toast.makeText(MainActivity.this, rating,Toast.LENGTH_SHORT).show();
            }
        });

        TextView btn=findViewById(R.id.go_drinks_menu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Drinks_Menu.class));
            }
        });

         btn=findViewById(R.id.FinalPage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FinalPage.class));
            }
        });


    }

    public void radioClicked(View view) {

        //is the button now checked
        boolean checked=((RadioButton) view).isChecked();
        //check which radio button  was clicked
        switch (view.getId()) {
            case R.id.rb1:
            if (checked)
                pizza.setPizza_size_price(800);
            break;
            case R.id.rb2:
            if(checked)
                pizza.setPizza_size_price(950);
            break;
            case R.id.rb3:
            if(checked)
                pizza.setPizza_size_price(1100);
            break;
        }
        total.setText("Total Pizza Price: " +String.format("%.2f",pizza.getPizza_size_price()) +"Ksh") ;



    }

    public void onCheckboxClicked(View view) {
        //is the view checked
        boolean checked=((CheckBox) view).isChecked();
        //check which check box was clicked
        switch (view.getId()){
            case R.id.cb1:
                if(checked)
                    pizza.setMeat_price(200);
                else
                    pizza.setMeat_price(0);
                break;
            case R.id.cb2:
                if(checked)
                    pizza.setCheese_price(150);
                else
                    pizza.setCheese_price(0);
                break;
            case R.id.cb3:
                if(checked)
                    pizza.setVeggies_price(100);
                else
                    pizza.setVeggies_price(0);
                break;
        }
        total.setText("Total Pizza Price: " +String.format("%.2f", calculate_total())+"Ksh" );

    }

    private double calculate_total(){
      total_price=pizza.getPizza_size_price()+pizza.getCheese_price()+pizza.getMeat_price()+pizza.getVeggies_price();
      return total_price;

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
    public void onSwitchClicked(View view) {
        Switch swButton=(Switch) view;
        if(swButton.isChecked())
            delivery.setText("Pizza to be Delivered");
        else
            delivery.setText("");

    }

}
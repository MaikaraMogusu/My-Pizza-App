package com.example.mypizzaorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Drinks_Menu extends AppCompatActivity {
    drinks drinks;
    TextView drinkTotal;
    double Total_Drink_price;
    Button btnRatedrink;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_menu);

       drinks =new drinks();
       drinkTotal=findViewById(R.id.drinkTotal);
       btnRatedrink=findViewById(R.id.btnRatedrink);
        final RatingBar rateDrink=findViewById(R.id.rateDrink);
        btnRatedrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating="Rating is :" +rateDrink.getRating();
                Toast.makeText(Drinks_Menu.this, rating,Toast.LENGTH_SHORT).show();
            }
        });


        TextView btn=findViewById(R.id.go_Pizza_Page);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Drinks_Menu.this,MainActivity.class));
            }
        });

        btn=findViewById(R.id.Fpage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Drinks_Menu.this,FinalPage.class));
            }
        });

    }


    public void radioClicked(View view) {

        boolean checked=((RadioButton) view).isChecked();
        //check which radio button  was clicked
        switch (view.getId()) {
            case R.id.rb4:
                if (checked)
                    drinks.setDrink_size_price(50);
                break;
            case R.id.rb5:
                if(checked)
                   drinks.setDrink_size_price(100);
                break;
            case R.id.rb6:
                if(checked)
                    drinks.setDrink_size_price(150);
                break;
    }
        drinkTotal.setText("Total for Drinks: " +String.format("%.2f",calculate_drink_total()) +"Ksh") ;



}
    private double calculate_drink_total(){
        Total_Drink_price=drinks.getDrink_size_price();
        return Total_Drink_price;
    }



    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.cb4:
                if (checked)
                    drinks.setQuarter_price(0);
                else
                    drinks.setQuarter_price(0);
                break;
            case R.id.cb5:
                if (checked)
                    drinks.setHalf_price(0);
                else
                    drinks.setHalf_price(0);
                break;
            case R.id.cb6:
                if (checked)
                    drinks.setLitre_price(0);
                else
                    drinks.setLitre_price(0);
                break;

        }
    }
}
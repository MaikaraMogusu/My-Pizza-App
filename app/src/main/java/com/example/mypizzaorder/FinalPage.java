package com.example.mypizzaorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalPage extends AppCompatActivity {

    Button exitBtn;
    TextView totalOrder;
    double grandTotal;
    Button btnOrder;
    MainActivity MainActivity;
    Drinks_Menu Drinks_Menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);


        totalOrder = findViewById(R.id.totalOrder);
        btnOrder=findViewById(R.id.btnOrder);
        MainActivity=new MainActivity();
        Drinks_Menu=new Drinks_Menu();



        exitBtn = findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        totalOrder.setText("Total Amount: " +String.format("%.2f", calculate_total_amount())+"Ksh" );

    }


    public double calculate_total_amount(){
        grandTotal=MainActivity.total_price+    Drinks_Menu.Total_Drink_price;
        return  grandTotal;
    }

    }

    

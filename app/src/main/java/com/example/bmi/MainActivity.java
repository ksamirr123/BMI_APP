package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edweight,edheight,edHeightIN;
        Button button;
        TextView txtResult;
        LinearLayout  Main;
        //change1


        edweight = findViewById(R.id.edweight);
        edheight = findViewById(R.id.edheight);
        edHeightIN = findViewById(R.id.edHeightIN);
        button = findViewById(R.id.button);
        txtResult = findViewById(R.id.txtResult);
        Main = findViewById(R.id.Main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt =   Integer.parseInt( edweight.getText().toString());
                int ft =   Integer.parseInt( edheight.getText().toString());
                int in =   Integer.parseInt( edHeightIN.getText().toString());
                int totalIn = ft*12+in;
                double totalCm = totalIn*2.53;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);
               if(bmi>25){
                   txtResult.setText("You Are Over Weight");
                   Main.setBackgroundColor(getResources().getColor(R.color.over));
               } else if(bmi<18){
                   txtResult.setText("You are UnderWeight");
                   Main.setBackgroundColor(getResources().getColor(R.color.under));
               }else{
                   txtResult.setText("You are Healthy");
                   Main.setBackgroundColor(getResources().getColor(R.color.healty));
               }


            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
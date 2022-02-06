package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText cd,cm,cy,bd,bm,by;
    private Button calculate;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         cd=findViewById(R.id.currentday_id);
         cm=findViewById(R.id.currentmonth_id);
         cy=findViewById(R.id.currentyear_id);
        bd=findViewById(R.id.birthday_id);
        bm=findViewById(R.id.birthmonth_id);
        by=findViewById(R.id.birthyear_id);
        calculate=findViewById(R.id.calculate_button_id);
        textView=findViewById(R.id.result_id);

        calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String number1 = cd.getText().toString();
        String number2 = cm.getText().toString();
        String number3 = cy.getText().toString();
        String number4 = bd.getText().toString();
        String number5 = bm.getText().toString();
        String number6 = by.getText().toString();
        //converting number string to double
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double num3 = Double.parseDouble(number3);
        double num4 = Double.parseDouble(number4);
        double num5 = Double.parseDouble(number5);
        double num6 = Double.parseDouble(number6);

        if(v.getId()==R.id.calculate_button_id)
        {
            int current_day,current_month,current_year,birth_day,birth_month,birth_year,
                    age_day,age_months,age_years;

            current_day= (int) num1;
            current_month= (int) num2;
            current_year= (int) num3;
            birth_day= (int) num4;
            birth_month= (int) num5;
            birth_year= (int) num6;

            if(current_day>=birth_day)
            {
                age_day=current_day-birth_day;
            }
            else
            {
                age_day=(current_day+30)-birth_day;
                current_month=current_month-1;
            }
            if(current_month>=birth_month)
            {
                age_months=current_month-birth_month;

            }
            else
            {
                age_months=(current_month+12)-birth_month;
                current_year=current_year-1;
            }
            age_years=current_year-birth_year;
            System.out.println();

            textView.setText(age_years+" years "+age_months+" months "+age_day+" days.");

        }

    }
}
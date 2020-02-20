package com.saif.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result_text_view;
    private TextView exp_text_view;
    private EditText num_a;
    private EditText num_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_text_view = findViewById(R.id.resultTextView);
        result_text_view.setText("");
        exp_text_view = findViewById(R.id.expTextView);
        exp_text_view.setText("");
        num_a = findViewById(R.id.numA);
        num_b = findViewById(R.id.numB);
    }
    private boolean isEmpty(EditText editText) {
        if(editText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }
    private void getResult(String op){
        String result_string = "";
        String exp_string = "";
        double result = 0;

        if(isEmpty(num_a)){
            result_string = "A can't be empty!";
            result_text_view.setText(result_string);
            return;
        }else if(isEmpty(num_b)){
            result_string = "B can't be empty!";
            result_text_view.setText(result_string);
            return;
        }

        String num_a_string = num_a.getText().toString();
        double a = Double.parseDouble(num_a_string);
        String num_b_string = num_b.getText().toString();
        double b = Double.parseDouble(num_b_string);

        if(op == "div" && b == 0){
            result_string = "B can't be zero!";
            result_text_view.setText(result_string);
            return;
        }

        switch(op){
            case "+": result = a + b;
                        break;
            case "-": result = a - b;
                        break;
            case "*": result = a * b;
                        break;
            case "/": result = a / b;
                        break;
        }
        Resources res = getResources();
        exp_string = res.getString(R.string.exp_text, num_a_string, op, num_b_string);
        exp_text_view.setText(exp_string);
        result_string = Double.toString(result);
        result_text_view.setText(result_string);
    }
    public void Add(View v) {
        getResult("+");
    }
    public void Sub(View v) {
        getResult("-");
    }
    public void Mul(View v) {
        getResult("*");
    }
    public void Div(View v) {
        getResult("/");
    }


}

package me.codeenzyme.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v) {
        TextView resultView = findViewById(R.id.result_tv);
        EditText firstNumEt = findViewById(R.id.first_num_et);
        EditText secondNumEt = findViewById(R.id.second_num_et);
        Spinner opsSpinner = findViewById(R.id.ops_spinner);

        String firstNumString = firstNumEt.getText().toString().trim();
        String secondNumString = secondNumEt.getText().toString().trim();

        if (TextUtils.isEmpty(firstNumString) || TextUtils.isEmpty(secondNumString))
            return;

        double firstNum = Double.parseDouble(firstNumString);
        double secondNum = Double.parseDouble(secondNumString);

        double result = 0;

        String ops = opsSpinner.getSelectedItem().toString();

        switch (ops) {
            case "Addition":
                result = Calculator.add(firstNum, secondNum);
                break;
            case "Subtraction":
                result = Calculator.subtract(firstNum, secondNum);
                break;
            case "Multiplication":
                result = Calculator.multiply(firstNum, secondNum);
                break;
            case "Division":
                result = Calculator.divide(firstNum, secondNum);
                break;
        }

        resultView.setText(String.valueOf(result));

    }
}
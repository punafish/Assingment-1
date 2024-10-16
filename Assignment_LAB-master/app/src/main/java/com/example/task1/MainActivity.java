package com.example.task1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText heightEditText, weightEditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.calculate_button);
        heightEditText = findViewById(R.id.height_edit_text);
        weightEditText = findViewById(R.id.weight_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        resultTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText("");
            }
        });

    }

    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float heightInMeters  = Float.parseFloat(heightStr); // Height is in meters
            float weight = Float.parseFloat(weightStr); // Weight is in kilograms

            float bmi = weight / (heightInMeters * heightInMeters);

            displayBMIResult(bmi);
        } else {
            resultTextView.setText("Please enter valid height and weight.");
        }
    }

    private void displayBMIResult(float bmi) {
        String bmiLabel;
        if (bmi < 16.00)
            bmiLabel = "অতিসংকুচিতা \n(Starvation)";
        else if (bmi >= 16.00 && bmi <= 16.99)
            bmiLabel = "অতিদুর্বলতা \n(Emaciation)";
        else if (bmi >= 17.00 && bmi <= 18.49)
            bmiLabel = "অতিপান্ডু \n(Underweight)";
        else if (bmi >= 18.50 && bmi <= 22.99)
            bmiLabel = "সাধারণ, কম পরিসীমা \n(Normal, low range)";
        else if (bmi >= 23.00 && bmi <= 24.99)
            bmiLabel = "সাধারণ, উচ্চ পরিসীমা \n(Normal, high range)";
        else if (bmi >= 25.00 && bmi <= 27.49)
            bmiLabel = "বেশি ওজন, কম পরিসীমা \n(Overweight, low range)";
        else if (bmi >= 27.50 && bmi <= 29.99)
            bmiLabel = "বেশি ওজন, উচ্চ পরিসীমা \n(Overweight, high range)";
        else if (bmi >= 30.00 && bmi <= 34.9)
            bmiLabel = "১ম শ্রেণীর স্থুলতা \n(1st degree obesity)";
        else if (bmi >= 35.00 && bmi <= 39.90)
            bmiLabel = "২য় শ্রেণীর স্থুলতা \n(2nd degree obesity)";
        else
            bmiLabel = "৩য় শ্রেণীর স্থুলতা \n(3rd degree obesity)";

        resultTextView.setText("BMI: " + bmi + "\n" + bmiLabel);
    }
}

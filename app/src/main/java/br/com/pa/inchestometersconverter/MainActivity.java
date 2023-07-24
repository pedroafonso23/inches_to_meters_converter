package br.com.pa.inchestometersconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editTextInches;
    Button buttonConvert;
    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupButtonConvertClickListener();
    }

    private void findViews() {
        editTextInches = findViewById(R.id.edit_text_inches);
        buttonConvert = findViewById(R.id.button_convert);
        textViewResult = findViewById(R.id.text_view_result);
    }

    private void setupButtonConvertClickListener() {
        buttonConvert.setOnClickListener(v -> {
            String inchesText = editTextInches.getText().toString();

            if (inchesText.isEmpty()) {
                resetResultAndWarnUser();
            } else {
                convertAndShowResult(inchesText);
            }
        });
    }

    private void resetResultAndWarnUser() {
        textViewResult.setText("");
        Toast.makeText(MainActivity.this, "Please, fill the Inches field", Toast.LENGTH_LONG).show();
    }

    private void convertAndShowResult(String inchesText) {
        double meters = convertToMeters(inchesText);
        String metersWithTwoDecimals = formatDoubleToTwoDecimals(meters);
        displayResult(metersWithTwoDecimals);
    }

    private double convertToMeters(String inchesText) {
        int inches = Integer.parseInt(inchesText);

        // conversion rate of inches to meters is 0.0254
        return inches * 0.0254;
    }

    private String formatDoubleToTwoDecimals(double meters) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");

        return decimalFormatter.format(meters);
    }

    private void displayResult(String meters) {
        textViewResult.setText("Result:\n" + meters + " meters");
    }
}
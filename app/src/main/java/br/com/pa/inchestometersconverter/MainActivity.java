package br.com.pa.inchestometersconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextInches;
    Button buttonConvert;
    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        double meters = convertToMeters(23);
        displayResult(meters);
    }

    private void findView() {
        editTextInches = findViewById(R.id.edit_text_inches);
        buttonConvert = findViewById(R.id.button_convert);
        textViewResult = findViewById(R.id.text_view_result);
    }

    private double convertToMeters(int inches) {
        return 1.23;
    }

    private void displayResult(double meters) {
        textViewResult.setText("Result:\n" + meters + " meters");
    }
}
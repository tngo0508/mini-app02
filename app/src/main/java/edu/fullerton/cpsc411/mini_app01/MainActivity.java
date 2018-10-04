package edu.fullerton.cpsc411.mini_app01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Locale;

import static java.util.Locale.US;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    Double networkSpeed, fileSize, result, to;
    EditText speedInput, sizeInput;
    TextView output;
    DecimalFormat decForm = new DecimalFormat("#.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedInput = findViewById(R.id.NetworkSpeedInput);
        sizeInput = findViewById(R.id.FileSizeInput);
        output = findViewById(R.id.Result);

        speedInput.addTextChangedListener(this);
        sizeInput.addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        try {
            networkSpeed = Double.valueOf(speedInput.getText().toString());
            fileSize = Double.valueOf(sizeInput.getText().toString());
        } catch (NumberFormatException e) {
            networkSpeed = 100.0;
            fileSize = 100.0;
        }
        result = cal(networkSpeed, fileSize);
        String time = toOneDec(result) + " seconds";
        output.setText(time);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private double cal(double networkSpeed,double fileSize) {
        return (networkSpeed * Math.pow(2,20) * 8) / (fileSize * Math.pow(10, 6));
    }

    private String toOneDec(double num) {
        return String.format(US, "%.1f", result);
    }
}

package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Test";
    SeekBar customSeekBar;
    TextView customValueProgress, totalPersonValue, tipValue, totalValue;
    RadioGroup radioGroup, radioGroup2;
    EditText billTotalInput;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customSeekBar = findViewById(R.id.customSeekBar);
        customValueProgress = findViewById(R.id.customValue);
        radioGroup = findViewById(R.id.tipRadioGroup);
        radioGroup2 = findViewById(R.id.splitRadioGroup);
        tipValue = findViewById(R.id.tipValue);
        totalValue = findViewById(R.id.totalValue);
        totalPersonValue = findViewById(R.id.totalPersonValue);
        billTotalInput = findViewById(R.id.billTotalInput);
        billTotalInput.getText();
        findViewById(R.id.clearButton).setOnClickListener(this);


        //Tip Radio Buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                double results;

                if(!billTotalInput.getText().toString().equals("")) {

                    if (checkedId == R.id.tenRadioButton) {
                        double value = Double.parseDouble(billTotalInput.getText().toString());
                        results = value - (value * .10);
                        tipValue.setText(String.valueOf(results));
                        totalValue.setText(String.valueOf(results));
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.fifteenRadioButton) {
                        double value = Double.parseDouble(billTotalInput.getText().toString());
                        results = value - (value * .15);
                        tipValue.setText(String.valueOf(results));
                        totalValue.setText(String.valueOf(results));
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.eighteenRadioButton) {
                        double value = Double.parseDouble(billTotalInput.getText().toString());
                        results = value - (value * .18);
                        tipValue.setText(String.valueOf(results));
                        totalValue.setText(String.valueOf(results));
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.customRadioButton) {
                        totalValue.setText(String.valueOf(customSeekBar.getProgress()));
                        tipValue.setText(String.valueOf(customSeekBar.getProgress()));
                        totalPersonValue.setText(String.valueOf(customSeekBar.getProgress()));
                    } else {

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_SHORT).show();
                }
            }


        });
        //Split By Radio Buttons
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                double results;
                double value;
                if(!billTotalInput.getText().toString().equals("")) {

                    if (checkedId == R.id.oneRadioButton) {
                        results = Double.parseDouble(totalValue.getText().toString());
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.twoRadioButton) {
                        value = Double.parseDouble(totalValue.getText().toString());
                        results = value / 2;
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.threeRadioButton) {
                        value = Double.parseDouble(totalValue.getText().toString());
                        results = value / 3;
                        totalPersonValue.setText(String.valueOf(results));
                    } else if (checkedId == R.id.fourRadioButton) {
                        value = Double.parseDouble(totalValue.getText().toString());
                        results = value / 2;
                        totalPersonValue.setText(String.valueOf(results));
                    } else {

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //SeekBar
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                customValueProgress.setText(String.valueOf(progress + "%"));

                int checked = radioGroup.getCheckedRadioButtonId();

               if(R.id.customRadioButton == checked) {
                   totalValue.setText(String.valueOf(progress));
                   tipValue.setText(String.valueOf(progress));
                   totalPersonValue.setText(String.valueOf(progress));
               }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    //Clear Button
    @Override
    public void onClick(View view) {

        billTotalInput.setText("");
        tipValue.setText("$0.0");
        totalPersonValue.setText("$0.0");
        totalValue.setText("$0.0");
        customValueProgress.setText("40%");
        radioGroup.clearCheck();
        radioGroup2.clearCheck();
    }

}
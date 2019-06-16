package com.andia.loice.flighttracker.view.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    final Calendar calendar = Calendar.getInstance();
    private ActivityMainBinding activityMainBinding;
    private EditText sourceAirport;
    private EditText destAirport;
    private EditText travelDate;
    private EditText returnDate;
    private Button submitBtn;
    private String source = "";
    private String dest = "";
    private String deptDate = "";
    private String retnDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sourceAirport = activityMainBinding.sourceAirport;
        destAirport = activityMainBinding.destAirport;
        travelDate = activityMainBinding.travelDate;
        returnDate = activityMainBinding.returnDate;
        submitBtn = activityMainBinding.submitBtn;

        initListeners();

    }

    private void initListeners() {

        DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        };

        sourceAirport.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                source = s.toString();

            }
        });

        destAirport.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dest = s.toString();
            }
        });

        travelDate.setOnClickListener(v -> {
            new DatePickerDialog(this,
                    date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))
                    .show();
            updateLabel(travelDate);
        });

        returnDate.setOnClickListener(v -> {
            new DatePickerDialog(this,
                    date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))
                    .show();
            updateLabel(returnDate);
        });

        submitBtn.setOnClickListener(v -> {
            if (source.isEmpty() && dest.isEmpty() && deptDate.isEmpty()) {
                Snackbar.make(activityMainBinding.inputView,
                        R.string.empty_text_prompt,
                        Snackbar.LENGTH_LONG)
                        .show();
            } else {
                Intent intent = new Intent(MainActivity.this, FlightListActivity.class);
                intent.putExtra("SOURCE", source);
                intent.putExtra("DESt", dest);
                intent.putExtra("DEPARTURE", deptDate);
                intent.putExtra("RETURN", retnDate);
                startActivity(intent);
            }
        });
    }

    private void updateLabel(EditText editText) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        editText.setText(sdf.format(calendar.getTime()));
    }
}

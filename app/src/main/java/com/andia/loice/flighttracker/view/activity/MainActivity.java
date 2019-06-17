package com.andia.loice.flighttracker.view.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import timber.log.Timber;

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

        Timber.plant(new Timber.DebugTree());

        initListeners();

    }

    private void initListeners() {

        DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        };


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

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
            travelDate.setText(sdf.format(calendar.getTime()));

        });

        returnDate.setOnClickListener(v -> {
            new DatePickerDialog(this,
                    date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))
                    .show();
            returnDate.setText(sdf.format(calendar.getTime()));
        });

        submitBtn.setOnClickListener(v -> {
            if (source.isEmpty() && dest.isEmpty() && deptDate.isEmpty()) {
                Snackbar.make(activityMainBinding.inputView,
                        R.string.empty_text_prompt,
                        Snackbar.LENGTH_LONG)
                        .show();
            } else if (isNetworkAvailable(this)) {
                Intent intent = new Intent(this, FlightListActivity.class);
                intent.putExtra("SOURCE", sourceAirport.getText().toString());
                intent.putExtra("DEST", destAirport.getText().toString());
                intent.putExtra("DEPARTURE", travelDate.getText().toString());
                intent.putExtra("RETURN", returnDate.getText().toString());
                startActivity(intent);
            }
        });
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

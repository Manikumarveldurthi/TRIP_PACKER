package com.example.trip_packer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SmartSuggestion extends AppCompatActivity {
    private Spinner categorySpinner;
    private EditText destinationEditText;
    private TextView tipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_suggestion);

        categorySpinner = findViewById(R.id.categorySpinner);
        destinationEditText = findViewById(R.id.destinationEditText);
        tipTextView = findViewById(R.id.tipTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.categories_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateTip();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        destinationEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateTip();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void updateTip() {
        String category = categorySpinner.getSelectedItem().toString();
        String destination = destinationEditText.getText().toString();

        // Check if category and destination are not empty
        if (!category.isEmpty() && !destination.isEmpty()) {
            String tip = PackingTips.getTipForCategoryAndDestination(category, destination);
            tipTextView.setText(tip);
        } else {
            tipTextView.setText("");
        }
    }
}

package com.example.trip_packer;


        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.List;


public class packing extends AppCompatActivity {
    private Spinner placesSpinner;
    private Button getTipsButton;
    private TextView tipsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing);


        placesSpinner = findViewById(R.id.places_spinner);
        getTipsButton = findViewById(R.id.get_tips_button);
        tipsTextView = findViewById(R.id.tips_text_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.india_places,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        placesSpinner.setAdapter(adapter);

        getTipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedPlace = placesSpinner.getSelectedItem().toString();
                List<String> items = PackingTips.getItemsForDestination(selectedPlace.toLowerCase());
                StringBuilder tips = new StringBuilder();

                for (String item : items) {
                    tips.append("• ").append(item).append("\n");
                }

                tipsTextView.setText(tips.toString());
            }
        });
    }
}






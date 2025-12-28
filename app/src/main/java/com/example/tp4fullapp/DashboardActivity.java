package com.example.tp4fullapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Spinner spinnerSalle;
    private Button btnManage;
    private String typeSalle = "";
    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvWelcome = findViewById(R.id.tvWelcome);
        spinnerSalle = findViewById(R.id.spinnerSalle);
        btnManage = findViewById(R.id.btnManage);

        String userEmail = getIntent().getStringExtra("USER_EMAIL");
        if (userEmail != null && !userEmail.isEmpty()) {
            tvWelcome.setText("Welcome " + userEmail);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.salle_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalle.setAdapter(adapter);

        spinnerSalle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeSalle = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnManage.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SalleActivity.class);
            intent.putExtra("typeSalle", typeSalle);
            startActivity(intent);
        });
    }
}

package com.example.tp4fullapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView tvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        tvResume = findViewById(R.id.tvResume);

        String nomSalle = getIntent().getStringExtra("nomSalle");
        String typeSalle = getIntent().getStringExtra("typeSalle");
        boolean video = getIntent().getBooleanExtra("video", false);
        boolean clim = getIntent().getBooleanExtra("clim", false);
        boolean wifi = getIntent().getBooleanExtra("wifi", false);

        String resume = "Nom de la salle: " + nomSalle + "\n"
                + "Type de salle: " + typeSalle + "\n"
                + "Vidéoprojecteur: " + (video ? "Oui" : "Non") + "\n"
                + "Climatisation: " + (clim ? "Oui" : "Non") + "\n"
                + "WiFi: " + (wifi ? "Oui" : "Non");

        tvResume.setText(resume);
    }
}

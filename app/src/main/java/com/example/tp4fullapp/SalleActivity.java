package com.example.tp4fullapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SalleActivity extends AppCompatActivity {

    private EditText etNomSalle;
    private Switch switchVideo;
    private CheckBox cbClim, cbWifi;
    private Button btnValider;
    private boolean video, clim, wifi;
    private String typeSalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salle);

        typeSalle = getIntent().getStringExtra("typeSalle");

        etNomSalle = findViewById(R.id.etNomSalle);
        switchVideo = findViewById(R.id.switchVideo);
        cbClim = findViewById(R.id.cbClim);
        cbWifi = findViewById(R.id.cbWifi);
        btnValider = findViewById(R.id.btnValider);

        etNomSalle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        switchVideo.setOnCheckedChangeListener((buttonView, isChecked) -> video = isChecked);

        cbClim.setOnCheckedChangeListener((buttonView, isChecked) -> clim = isChecked);

        cbWifi.setOnCheckedChangeListener((buttonView, isChecked) -> wifi = isChecked);

        btnValider.setOnClickListener(v -> showPopup());
    }

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Confirmer la réservation ?");
        builder.setPositiveButton("Oui", (dialog, which) -> {
            Intent intent = new Intent(SalleActivity.this, ConfirmationActivity.class);
            String nomSalle = etNomSalle.getText().toString();
            intent.putExtra("nomSalle", nomSalle);
            intent.putExtra("typeSalle", typeSalle);
            intent.putExtra("video", video);
            intent.putExtra("clim", clim);
            intent.putExtra("wifi", wifi);
            startActivity(intent);
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }
}

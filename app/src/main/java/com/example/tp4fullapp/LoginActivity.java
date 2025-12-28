package com.example.tp4fullapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private MaterialButton loginButton;

    // Define the correct email and password
    private final String CORRECT_EMAIL = "admin@gmail.com";
    private final String CORRECT_PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.equals(CORRECT_EMAIL) && password.equals(CORRECT_PASSWORD)) {
                // Credentials are correct, navigate to DashboardActivity
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                intent.putExtra("USER_EMAIL", email);
                startActivity(intent);
                finish(); // Optional: close the login activity
            } else {
                // Credentials are incorrect, show a toast message
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.rafikiplushub.user_credentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rafikiplushub.MainActivity;
import com.example.rafikiplushub.R;
import com.example.rafikiplushub.SplashScreen;

public class Login extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewUsernameError;
    private TextView textViewPasswordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewUsernameError = findViewById(R.id.textViewUsernameError);
        textViewPasswordError = findViewById(R.id.textViewPasswordError);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        TextView textViewSignUp = findViewById(R.id.textViewSignUp);

        // Set onClickListener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate username and password
                validateCredentials();
            }
        });
        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch SignUpActivity
                Intent intent = new Intent(Login.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void validateCredentials() {
        // Reset error messages
        textViewUsernameError.setVisibility(View.GONE);
        textViewPasswordError.setVisibility(View.GONE);

        // Get entered username and password
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Check if username is empty
        if (username.isEmpty()) {
            textViewUsernameError.setVisibility(View.VISIBLE);
            textViewUsernameError.setText("Please enter a username");

            // Hide error message after 5 seconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewUsernameError.setVisibility(View.GONE);
                }
            }, 2000);
            return;
        }

        // Check if password is empty
        if (password.isEmpty()) {
            textViewPasswordError.setVisibility(View.VISIBLE);
            textViewPasswordError.setText("Please enter a password");

            // Hide error message after 5 seconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    textViewPasswordError.setVisibility(View.GONE);
                }
            }, 2000);
            return;
        }
        Intent i = new Intent(Login.this, MainActivity.class);
        startActivity(i);

        // TODO: Add your authentication logic here
        // For example, you can check the username and password against a database or an authentication service.

        // For demonstration purposes, show a toast indicating successful login
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }
}
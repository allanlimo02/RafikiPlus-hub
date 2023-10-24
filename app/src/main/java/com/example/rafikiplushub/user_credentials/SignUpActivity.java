package com.example.rafikiplushub.user_credentials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rafikiplushub.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize UI components
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);
        TextView textViewGoogleSignUp = findViewById(R.id.textViewGoogleSignUp);
        TextView textViewFacebookSignUp = findViewById(R.id.textViewFacebookSignUp);

        // Set onClickListener for the Sign Up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate user input
                if (validateInput()) {
                    // Proceed with the signup process
                    performSignUp();
                }
            }
        });

        // Set onClickListeners for Google and Facebook sign up options (you can implement the actual sign up logic here)
        textViewGoogleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement Google sign up logic
                Toast.makeText(SignUpActivity.this, "Sign Up with Google clicked", Toast.LENGTH_SHORT).show();
            }
        });

        textViewFacebookSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement Facebook sign up logic
                Toast.makeText(SignUpActivity.this, "Sign Up with Facebook clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInput() {
        // Validate first name
        if (editTextFirstName.getText().toString().trim().isEmpty()) {
            editTextFirstName.setError("Enter your first name");
            return false;
        }

        // Validate last name
        if (editTextLastName.getText().toString().trim().isEmpty()) {
            editTextLastName.setError("Enter your last name");
            return false;
        }

        // Validate email
        String email = editTextEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError("Enter your email");
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email address");
            return false;
        }

        // All input is valid
        return true;
    }

    private void performSignUp() {
        // Implement the sign-up logic here
        Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show();
        // You can navigate to the next activity or perform other actions after successful sign up.
    }
}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {

    private EditText accountNameEditText;
    private EditText passwordEditText;
    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        accountNameEditText = findViewById(R.id.accountNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        connectButton = findViewById(R.id.connectButton);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountName = accountNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Perform your connection logic here (e.g., authentication)
                if (isValidCredentials(accountName, password)) {
                    // Start the MainActivity (main app UI)
                    Intent intent = new Intent(ConnectionActivity.this, AccountActivity.class);
                    startActivity(intent);
                    finish(); // Finish the ConnectionActivity
                } else {
                    // Display an error message
                    Toast.makeText(ConnectionActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Replace with your actual authentication logic
    private boolean isValidCredentials(String accountName, String password) {
        // Example: Check if accountName is "student" and password is "password"
        return accountName.equals("amine") && password.equals("1234");
    }
}
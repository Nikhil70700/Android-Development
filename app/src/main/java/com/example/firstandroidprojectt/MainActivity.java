package com.example.firstandroidprojectt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.firstandroidprojectt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setup submit button click listener
        setupSubmitButton();

        Log.d(TAG, "MainActivity created successfully");
    }

    private void setupSubmitButton() {
        // Using view binding to access the submit button
        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmitClick();
            }
        });
    }

    private void handleSubmitClick() {
        // Get the text from the EditText
        String name = binding.nameEditText.getText().toString().trim();

        if (!name.isEmpty()) {
            // Show success message
            Toast.makeText(this, "Hello " + name + "! Your message has been submitted.",
                    Toast.LENGTH_LONG).show();

            // Clear the input field
            binding.nameEditText.setText("");

            // Log the submission
            Log.d(TAG, "Form submitted successfully with name: " + name);

            // Here you can add code to actually send the data somewhere
            // For example: sendDataToServer(name);

        } else {
            // Show error message for empty input
            Toast.makeText(this, "Please enter your name before submitting",
                    Toast.LENGTH_SHORT).show();

            // Request focus on the EditText
            binding.nameEditText.requestFocus();

            Log.w(TAG, "Submit attempted with empty name field");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up binding reference to prevent memory leaks
        binding = null;
    }
}
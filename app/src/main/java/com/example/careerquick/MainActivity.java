package com.example.careerquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        final EditText editTextEmail = findViewById(R.id.editTextEmail);


        // Toggle password visibility when eye icon is clicked
        editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (editTextPassword.getRight() - editTextPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // Toggle password visibility
                        if(editTextPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                            // Show password
                            editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        } else {
                            // Hide password
                            editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                        // Move cursor to the end of the text
                        editTextPassword.setSelection(editTextPassword.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });

        // Find the TextView for Create Account
        TextView textViewCreateAccount = findViewById(R.id.buttonCreateAccount);

        // Set OnClickListener for Create Account TextView
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open new activity when Create Account is clicked
                Intent intent = new Intent(MainActivity.this, CreatAccountActivity.class); // Change NewActivity to your desired activity
                startActivity(intent);
            }
        });

        // Find the login button
        Button buttonLogin = findViewById(R.id.buttonLogin);

        // Set OnClickListener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open new activity when the login button is clicked
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class); // Change YourDesiredActivity to the activity you want to navigate to after login
                startActivity(intent);
            }
        });
    }
}

package com.ricardogwill.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView loginTextView, usernameTextView, passwordTextView, attemptsTextView, attemptCountTextView;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    int attemptCounter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTextView = findViewById(R.id.login_textview);
        usernameTextView = findViewById(R.id.username_textview);
        passwordTextView = findViewById(R.id.password_textview);
        attemptsTextView = findViewById(R.id.attempts_textview);
        attemptCountTextView = findViewById(R.id.attempt_count_textview);
        usernameEditText = findViewById(R.id.username_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        loginButton = findViewById(R.id.login_button);

        attemptCountTextView.setText(Integer.toString(attemptCounter));

        loginButtonOnClick();
    }

    public void loginButtonOnClick() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEditText.getText().toString().equals("user") && passwordEditText.getText().toString().equals("pass")) {
                    Toast.makeText(LoginActivity.this, "Correct Login Info!", Toast.LENGTH_SHORT).show();
                    attemptCounter = 5;
                    attemptCountTextView.setText(Integer.toString(attemptCounter));
                    Intent openUserActivityIntent = new Intent(getApplicationContext(), UserActivity.class);
                    startActivity(openUserActivityIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Incorrect Login Info.", Toast.LENGTH_SHORT).show();
                    attemptCounter--;
                    attemptCountTextView.setText(Integer.toString(attemptCounter));
                    if (attemptCounter == 0) {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });
    }

}

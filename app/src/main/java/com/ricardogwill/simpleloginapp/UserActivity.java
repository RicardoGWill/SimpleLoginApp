package com.ricardogwill.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        returnButton = findViewById(R.id.return_button);

        returnButtonOnClick();
    }

    public void returnButtonOnClick() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnButtonIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(returnButtonIntent);
            }
        });
    }

}

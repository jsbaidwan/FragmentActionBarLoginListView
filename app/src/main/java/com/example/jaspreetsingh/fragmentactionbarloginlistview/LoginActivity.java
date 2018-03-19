package com.example.jaspreetsingh.fragmentactionbarloginlistview;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        Button loginButton = (Button) findViewById(R.id.button_login_page);

        // Set a click listener on the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link HomeActivity}
                Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);

                //Start the new HomeActivity
                startActivity(homeIntent);
            }
        });
    }
}

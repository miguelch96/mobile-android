package com.miguelch96.pichangapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.miguelch96.pichangapp.R;
import com.miguelch96.pichangapp.models.Equipo;

public class LoginActivity extends AppCompatActivity {

    EditText emailET;
    EditText passwordET;
    Button loginButton;
    TextView newTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.emailEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        newTV = (TextView) findViewById(R.id.newTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailET.getText().toString().equals("admin")&&passwordET.getText().toString().equals("admin")){

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }
            }
        });



    }
}

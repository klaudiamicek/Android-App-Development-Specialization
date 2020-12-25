package com.example.testing;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class LoginActivity extends AppCompatActivity {
    AutoCompleteTextView email;
    EditText password;
    Button login;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(AutoCompleteTextView)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        login=(Button) findViewById(R.id.email_sign_in_button);
        error=(TextView)findViewById(R.id.error);
        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                //email and password text variables
                String emailText=email.getText().toString();
                String passwordText=password.getText().toString();
                //if email address not valid, displays text "Invalid email address"
                if(!LoginUtils.isValidEmailAddress(emailText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(Integer.parseInt("Invalid email address")));
                }
                //if password not at least 8 characters, displays text "The provided password is too short"
                else if(!LoginUtils.passwordSize(passwordText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(Integer.parseInt("The provided password is too short")));
                }
                //if password is all spaces, displays text "The provided password is invalid"
                else if(LoginUtils.allSpaces(passwordText)){
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(Integer.parseInt("The provided password is invalid")));
                //else (no errors) so displays "Login success"
                }else {
                    error.setVisibility(View.VISIBLE);
                    error.setText(getString(Integer.parseInt("Login success")));
                }

            }
        });
    }
}

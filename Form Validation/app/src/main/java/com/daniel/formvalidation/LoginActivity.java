package com.daniel.formvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // Intialization

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreateAccount;
    String Username, Password;
    int formsuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find objects using its ID
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);


        //Event listener for Login button 
        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                // Function of button Login once it was clicked

                formsuccess = 2; // 2 since we have 2 Objects to validate

                Username = etUsername.getText().toString();
                Password = etPassword.getText().toString();


                // If username is null
                if(Username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--; //always minus 1 the formsuccess if the form has an error
                }
                //check if password is null
                if (Password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--; //always minus 1 the formsuccess if the form has an error
                }
                //Check if form is validated
                if (formsuccess == 2) {
                    Toast.makeText(this, "FORM VALIDATE", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tvCreateAccount:
                // FUnction of TextView Create account once it was clicked
                Intent signup = new Intent(this, SignupActivity.class); // We'll going to create a class later
                startActivity(signup);
                break;
        }
    }
}

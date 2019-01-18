package com.daniel.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    // Initialization

    EditText etUsername, etPassword, etConfirmPassword, etFullName ;
    String Username, Password, ConfirmPassword, FullName;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.btnSave:

                formsuccess = 4;

                Username = etUsername.getText().toString();
                Password = etPassword.getText().toString();
                ConfirmPassword = etConfirmPassword.getText().toString();
                FullName = etFullName.getText().toString();

                if(Username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }
                if(Password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }
                if(!ConfirmPassword.equals(Password)) {
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }
                if(FullName.equals("")) {
                    etFullName.setError("This field is required");
                    formsuccess--;
                }
                if (formsuccess == 4) {
                    Toast.makeText(this, "FORM VALIDATE", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.btnCancel:
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

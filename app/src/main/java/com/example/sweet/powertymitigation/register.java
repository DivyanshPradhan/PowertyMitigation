package com.example.sweet.powertymitigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {
    EditText fname, lname, password, cpassword, email;
    String FirstName, LastName, Password, ConfrimPassword, Email;
    PovertyDataBaseAdapter povertyDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fname = (EditText) findViewById(R.id.fn);
        lname = (EditText) findViewById(R.id.ln);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        email = (EditText) findViewById(R.id.email);
    }

    public void Register(View view) {
        FirstName = fname.getText().toString();
        LastName = lname.getText().toString();
        Password = password.getText().toString();
        ConfrimPassword = cpassword.getText().toString();
        Email = email.getText().toString();


            if(fname.length()>1 && lname.length()>1) {
                if (password.length()>=8) {
                    if (Password.equals(ConfrimPassword)) {
                        povertyDataBaseAdapter = new PovertyDataBaseAdapter(getApplicationContext());
                        long id = povertyDataBaseAdapter.addUser(FirstName, LastName, Password, Email);
                        Log.d("App:", "" + id);
                        Message.message(this, "Register Sucessfully");
                        finish();
                        startActivity(new Intent(this, Home.class));
                    } else
                        Message.message(this, "password Dont match");
                } else
                    Message.message(this, "Fill passwords properly");
            }
                else
                    Message.message(this, "Fill in details properly");

            }



}
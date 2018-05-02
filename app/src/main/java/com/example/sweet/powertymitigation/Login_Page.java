 package com.example.sweet.powertymitigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Page extends AppCompatActivity {

    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        SharedPreferences sf=getSharedPreferences("credentials", Context.MODE_PRIVATE); //If user is already loggin then bypass te login and register screen
        String name=sf.getString("Email","");
        if((name.length())>0)
        {
            Intent i=new Intent(this,MainActivity.class);
            finish();
        }
    }
    public  void register(View view)
    {
        Intent intent=new Intent(this,register.class);
        startActivity(intent);
        Toast.makeText(this,"Register here",Toast.LENGTH_LONG).show();
        finish();
    }

    public void login(View view)
    {
        String name = editText.getText().toString();
        String pass = editText2.getText().toString();
        PovertyDataBaseAdapter povertyDataBaseAdapter = new PovertyDataBaseAdapter(this);
        if(povertyDataBaseAdapter.getUser(name,pass))
        {
            Intent i = new Intent(this,Home.class);
            startActivity(i);
            Message.message(this,"Login Succesfully");
        }
        else if(name.equals("admin@povertymitigation") && pass.equals("qazwsx"))
        {
            Intent i=new Intent(this,admin.class);
            startActivity(i);
            finish();
        }
        else
        {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
        }

    }

    public void imageviewlogo(View view)
    {
        Intent intent=new Intent(this,AboutUs.class);
        startActivity(intent);
        Toast.makeText(this,"AboutUs",Toast.LENGTH_LONG).show();
    }
}
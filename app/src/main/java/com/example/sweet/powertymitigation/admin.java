package com.example.sweet.powertymitigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void getAllData(View view)
    {
        PovertyDataBaseAdapter pdb1=new PovertyDataBaseAdapter(this);
        String data=pdb1.getDataBase();
        Message.message(this,data);
    }
    public void logout(View view)
    {
        Intent intent =new Intent(this,Login_Page.class);
        startActivity(intent);
        finish();
    }
}

package com.example.sweet.powertymitigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    EditText editText, editText2;
    RadioGroup radioGroup;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        radioGroup = (RadioGroup) findViewById(R.id.age);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.Infant:
                        Message.message(Home.this, "infant");
                        age = "Infant";
                        break;
                    case R.id.Kid:
                        Message.message(Home.this, "kid");
                        age = "Kid";
                        break;
                    case R.id.Young:
                        Message.message(Home.this, "young");
                        age = "young";
                        break;
                    case R.id.Old:
                        Message.message(Home.this, "old");
                        age = "old";
                        break;

                }
            }
        });
    }

    public  void Submit(View view)
    {
        PovertyDataBaseAdapter povertyDataBaseAdapter =new PovertyDataBaseAdapter(this);
        povertyDataBaseAdapter.form(editText.getText().toString(),editText2.getText().toString(),age);

    }
}
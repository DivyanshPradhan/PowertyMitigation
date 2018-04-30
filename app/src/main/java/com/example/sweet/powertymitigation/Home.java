package com.example.sweet.powertymitigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    EditText editText, editText2;
    RadioGroup radioGroup;
    String age;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ToggleButton toggleButton;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        actionBar = getSupportActionBar();
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        radioGroup = (RadioGroup) findViewById(R.id.age);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Archive:
                        Toast.makeText(Home.this,"Archive",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                }

        }

        return false;
    }

    public  void Submit(View view)
    {
        PovertyDataBaseAdapter povertyDataBaseAdapter =new PovertyDataBaseAdapter(this);
        povertyDataBaseAdapter.form(editText.getText().toString(),editText2.getText().toString(),age);

    }
}
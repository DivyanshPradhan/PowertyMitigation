package com.example.sweet.powertymitigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    EditText editText, editText2;
    RadioGroup radioGroup;
    String age;
    PovertyDataBaseAdapter povertyDataBaseAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ToggleButton toggleButton;
    Toolbar toolbar;
    ActionBar actionBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
                        Message.message(Home.this, "view request");

                        break;
                    case R.id.Archive2:
                        Message.message(Home.this, "About us clicked");
                        break;
                    case R.id.Archive3:
                        Message.message(Home.this, "FeedBack And Support is clicked");
                        break;
                    case R.id.Archive4:


                        break;

                }
                return false;
            }
        });

        View layout = navigationView.getHeaderView(0);
        TextView textView = layout.findViewById(R.id.username);
        textView.setText(getIntent().getStringExtra("Name"));


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

        /*PrefManager prefManager = new PrefManager(getSharedPreferences("PM", Context.MODE_PRIVATE));
        Log.d("App:",prefManager.getData());
        prefManager = null;*/





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
        Message.message(this,"Data Register Succesfully");

    }
}
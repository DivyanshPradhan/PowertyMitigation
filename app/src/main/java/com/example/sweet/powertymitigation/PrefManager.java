package com.example.sweet.powertymitigation;

import android.content.SharedPreferences;
import android.content.Context;

public class PrefManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public PrefManager(SharedPreferences sharedPreferences)
    {
        this.sharedPreferences = sharedPreferences;
        this.editor = this.sharedPreferences.edit();
    }

    public void putData(String...data)
    {
        String full_name = data[0] + " " + data[1];
        editor.putString("Name",full_name);
    }

    public String getData()
    {
        String full_name = sharedPreferences.getString("Name","N/a");
        return full_name;
    }

}

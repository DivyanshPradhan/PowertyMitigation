package com.example.sweet.powertymitigation;

import android.content.Context;
import android.widget.Toast;

public class Message
{
    public static void message(Context context, String string)
    {
        Toast.makeText(context, string,Toast.LENGTH_SHORT).show();
    }

}

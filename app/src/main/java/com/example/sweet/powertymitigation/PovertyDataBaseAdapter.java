package com.example.sweet.powertymitigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

public class PovertyDataBaseAdapter {
    Context context;

    public PovertyDataBaseAdapter(Context context) {
        this.context = context;
    }

    public long form(String name,String address,String age)
    {
        SQLiteDatabase db = new PovertyDatabase(context).getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(PovertyDatabase.NAME,name);
        values.put(PovertyDatabase.LOCATION,address);
        values.put(PovertyDatabase.AGE,age);
        long last_id=db.insert(PovertyDatabase.TABLE_NAME2,null,values);
        db.close();
        return last_id;
    }

    public long addUser(String FirstName, String LastName, String Password, String Email) {
        SQLiteDatabase db = new PovertyDatabase(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PovertyDatabase.FNAME, FirstName);
        values.put(PovertyDatabase.LNAME, LastName);
        values.put(PovertyDatabase.PASSWORD, Password);
        values.put(PovertyDatabase.EMAIL, Email);
        long last_id = db.insert(PovertyDatabase.TABLE_NAME, null, values);
        db.close();
        return last_id;
    }

    public boolean getUser(String name,String pass)
    {
        SQLiteDatabase db = new PovertyDatabase(context).getReadableDatabase();
        String columns[] = new String[]{PovertyDatabase.FNAME,PovertyDatabase.PASSWORD};
        String arg[] = new String[]{name,pass};
        Cursor cursor = db.query(PovertyDatabase.TABLE_NAME,columns,PovertyDatabase.FNAME + "=?"+ " AND " +  PovertyDatabase.PASSWORD + "=?",arg,null,null,null);
        if(cursor.getCount() > 0)
       {
           return true;
       }
       return false;
    }

    class PovertyDatabase extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "user";
        private static final String TABLE_NAME = "register";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "id";
        private static final String FNAME = "fname";
        private static final String LNAME = "lname";
        private static final String PASSWORD = "password";
        private static final String EMAIL = "email";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + FNAME + " TEXT," + LNAME + " TEXT, " + PASSWORD + " TEXT," + EMAIL + " TEXT " + ")";

        private  static  final  String TABLE_NAME2="help";
        private  static  final  String NAME="name";
        private  static  final  String LOCATION="location";
        private  static  final  String ID="id";
        private  static  final  String AGE="age";
        private  static  final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME +
                " TEXT," + LOCATION + " TEXT," + AGE + " TEXT" + " ) ";
        public PovertyDatabase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                sqLiteDatabase.execSQL(CREATE_TABLE2);
                Message.message(context, "DataBase Created");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
}
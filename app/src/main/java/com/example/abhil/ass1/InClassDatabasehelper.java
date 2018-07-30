package com.example.abhil.ass1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import java.util.Date;

public class InClassDatabasehelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "inclass"; // name of the DB
    private static final int DB_VERSION = 1; // version of the DB
    public static final String TABLE_NAME = "PERSON"; // name of the Table
 public static final String TABLE_NAME_BMI = "BMI";
    public InClassDatabasehelper(Context context){
        super(context,DB_NAME,null, DB_VERSION); // null is for cursors
    }
    @Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"EMAIL TEXT,"
                + "NAME TEXT, "
                + "PASSWORD TEXT, " // Never store passwords in clear text in real apps
                + "HEALTH_CARD_NUMB TEXT, "
                + "DATE TEXT);");
      //  Date today = new Date(); // we want to start with some initial data
 db.execSQL("CREATE TABLE "+TABLE_NAME_BMI+" ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "HEIGHT TEXT, "
                + "WEIGHT TEXT, "
                + "BMI TEXT, "
                + "DATE DATE, "
                + "EMAIL TEXT);");
     /*   ContentValues personValues = new ContentValues();
        personValues.put("EMAIL", "flori1428@gmail.com");
        personValues.put("NAME", "Abhimanyu");
        personValues.put("PASSWORD", "Abhilash@28");
                personValues.put("HEALTH_CARD_NUMB", "1234 5678 9101");
                        personValues.put("DATE", today.getTime());
        db.insert(TABLE_NAME,null, personValues); */


    }
    //@Override
   // public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    //}
}

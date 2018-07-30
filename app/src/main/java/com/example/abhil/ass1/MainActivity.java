package com.example.abhil.ass1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
Calendar myCalendar;
    private int year, month, day;
    EditText edittext;

    private DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            showDate(year, monthOfYear+1, dayOfMonth);
        }
    };

    private void showDate(int year, int month, int day) {
        edittext.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		  edittext= (EditText) findViewById(R.id.dob);

        myCalendar = Calendar.getInstance();
        year = myCalendar.get(Calendar.YEAR);

        month = myCalendar.get(Calendar.MONTH);
        day = myCalendar.get(Calendar.DAY_OF_MONTH);

      /*  InClassDatabasehelper helper = new   InClassDatabasehelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
// run a query
        Cursor cursor = db.query(  InClassDatabasehelper.TABLE_NAME,new String[]
                        {"NAME","PASSWORD","DATE"},
                null,null,null,null,null); //
        if (cursor.moveToFirst()){
            String name = cursor.getString(0);
            EditText results = (EditText) findViewById(R.id.person_name);
            results.setText(name);
        }
        cursor.close(); // cleanu
		 db.close(); */
}
@SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    date, year, month, day);
        }
        return null;
    }

    public void onClickEnter(View view) {
        Intent intent = new Intent(this, result.class);

        startActivity(intent);
    }

	public void registerUsermain(View view){
        EditText name = (EditText)findViewById(R.id.personName);
        EditText dob = (EditText)findViewById(R.id.dob);
        EditText health = (EditText)findViewById(R.id.health);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password = (EditText)findViewById(R.id.password);

        dob.setError(null);
        if(name.getText().toString().equals("")){
            name.setError("This is required field!");
            name.requestFocus();
        }else if(dob.getText().toString().equals("")){
            dob.setError("This is required field!");
            dob.requestFocus();
        }else if(health.getText().toString().equals("")){
            health.setError("This is required field!");
            health.requestFocus();
        }else if(email.getText().toString().equals("")){
            email.setError("This is required field!");
            email.requestFocus();
        }else if(password.getText().toString().equals("")){
            password.setError("This is required field!");
            password.requestFocus();
        }else {
            InClassDatabasehelper helper = new InClassDatabasehelper(MainActivity.this);
            SQLiteDatabase db = helper.getWritableDatabase();

            ContentValues personValues = new ContentValues();
            personValues.put("NAME", name.getText().toString());
            personValues.put("DATE", dob.getText().toString());
            personValues.put("HEALTH_CARD_NUMB", health.getText().toString());
            personValues.put("EMAIL", email.getText().toString());
            personValues.put("PASSWORD", password.getText().toString());
            db.insert(InClassDatabasehelper.TABLE_NAME, null, personValues);

            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
    }
}

}
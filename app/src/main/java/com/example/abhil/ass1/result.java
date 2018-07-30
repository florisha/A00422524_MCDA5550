package com.example.abhil.ass1;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
//import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Date;

public class result extends AppCompatActivity {

private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
 Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            email = bundle.getString("email");
        }
    }

  public void viewHistoryList(View view){
        Intent bmiListIntent = new Intent(result.this,BMIListActivity.class);
        Bundle b = new Bundle();
        b.putString("email",email);
        bmiListIntent.putExtras(b);
        startActivity(bmiListIntent);
    }

    public void calculateBMI(View view){
        EditText height = (EditText) findViewById(R.id.height);
        String value = height.getText().toString();
        Double heightAsInt = Double.parseDouble(value);
        //System.out.println("Here ids height"+heightVal);

        EditText weight = (EditText) findViewById(R.id.weight);
        String value1 = height.getText().toString();
        Double weightAsInt = Double.parseDouble(value1);
   //     System.out.println("Here ids weight"+weightVal);

        Double calc = (weightAsInt/(heightAsInt * heightAsInt));
        EditText result =(EditText) findViewById(R.id.result);

        //print result
        result.setText(calc.toString());
    
	
	
	System.out.println("email::"+email);

        InClassDatabasehelper helper = new InClassDatabasehelper(result.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ContentValues bmiValues = new ContentValues();
        bmiValues.put("HEIGHT", height.getText().toString());
        bmiValues.put("WEIGHT", weight.getText().toString());
        bmiValues.put("BMI", calc.toString());
        bmiValues.put("DATE", dateFormat.format(new Date()));
        bmiValues.put("EMAIL", email);
        db.insert(InClassDatabasehelper.TABLE_NAME_BMI,null, bmiValues);



    }
}

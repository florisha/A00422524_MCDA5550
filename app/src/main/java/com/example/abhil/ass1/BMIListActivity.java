package com.example.abhil.ass1;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLOutput;

public class BMIListActivity extends ListActivity {
  //  BMIResult[] results;
 List<BMIResult> results = new ArrayList<BMIResult>();
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);
   Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            email = bundle.getString("email");
        
		}
	//	 BMIResult[] results={new BMIResult(5.5,100),new BMIResult(4.3,156)};
		 InClassDatabasehelper helper = new InClassDatabasehelper(BMIListActivity.this);
		 SQLiteDatabase db = helper.getWritableDatabase();
		  Cursor resultSet = db.rawQuery("Select BMI,DATE from "+InClassDatabasehelper.TABLE_NAME_BMI+" where EMAIL='" + email +"'",null);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df2 = new DecimalFormat(".##");
        while(resultSet.moveToNext()) {
            BMIResult bmi = new BMIResult();
            double bmiValue = Double.parseDouble(resultSet.getString(0));

            bmi.setBmi(Double.parseDouble(df2.format(bmiValue)));
            bmi.setDate(resultSet.getString(1));
            results.add(bmi);
        }

       
        ListView listBMIResult=getListView();
        ArrayAdapter<BMIResult>listAdapter=new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,
                results
        );
        listBMIResult.setAdapter(listAdapter);



    }
    //ADD activity to do something on click.
    public void onListItemClick(ListView listView, View itemView, int position,long id)
    {
      //  System.out.println("Clicked on "+results[position].toString());
    }

}

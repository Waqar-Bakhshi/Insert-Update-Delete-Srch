package com.example.waqarcci.my_newdatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search_Activity extends AppCompatActivity {

    EditText searchtext;
    Button btnsearch;
    TextView name, email;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

    databaseHelper = new DatabaseHelper(this);

    searchtext = (EditText) findViewById(R.id.etSearchData);

    btnsearch =(Button)findViewById(R.id.btSearchGet);

    name = (TextView) findViewById(R.id.tvSearchName) ;
        email = (TextView) findViewById(R.id.tvSearchEmail) ;



    btnsearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor cursor = databaseHelper.getData(searchtext.getText().toString());

            name.setText("");
            email.setText("");

            while (cursor.moveToNext())
            {
                name.setText(cursor.getString(1));
                email.setText(cursor.getString(3));

            }

        }
    });

    }
}

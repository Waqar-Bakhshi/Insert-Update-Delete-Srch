package com.example.waqarcci.my_newdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    Button insert;
    Button searchData;
    Button btUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        insert = (Button) findViewById(R.id.btAdd);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent AddActivity = new Intent(MainActivity.this, Add_Activity.class);
                startActivity(AddActivity);
            }
        });
        searchData = (Button) findViewById(R.id.btSerach);

        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearch = new Intent(MainActivity.this,Search_Activity.class);
                startActivity(intentSearch);

            }
        });

        btUpdate= (Button) findViewById(R.id.btupdate);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(MainActivity.this,Update_Activity.class);
                startActivity(intentUpdate);
            }
        });




        btnDelete = (Button) findViewById(R.id.btDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Delete_Activity.class);
                startActivity(intent);
            }
        });


    }
}
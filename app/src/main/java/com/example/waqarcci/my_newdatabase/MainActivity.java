package com.example.waqarcci.my_newdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    Button insert;

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
    }
}
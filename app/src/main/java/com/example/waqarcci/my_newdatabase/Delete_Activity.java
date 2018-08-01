package com.example.waqarcci.my_newdatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Activity extends AppCompatActivity {


    Button btnsDelete;
    EditText phone ;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_);

        databaseHelper = new DatabaseHelper (this);

        btnsDelete = (Button) findViewById(R.id.btDelete);
        phone = (EditText) findViewById(R.id.etNumber);

        btnsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean result =    databaseHelper.deleteData(phone.getText().toString());
                if (result)
                {
                    Toast.makeText(Delete_Activity.this, "data Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Delete_Activity.this, "data not Deleted ", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
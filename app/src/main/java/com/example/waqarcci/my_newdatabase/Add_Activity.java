package com.example.waqarcci.my_newdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Activity extends AppCompatActivity {

    DatabaseHelper databaseHelper ;
    EditText name, phone , email;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);

        databaseHelper = new DatabaseHelper (this);

        name = (EditText) findViewById(R.id.etNAME);
        phone = (EditText) findViewById(R.id.etNumber);
        email = (EditText) findViewById(R.id.etEmail);

        save = (Button) findViewById(R.id.SAVE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertData (name.getText().toString(),Integer.parseInt(phone.getText().toString()) ,email.getText().toString());
                if (result)
                {
                    Toast.makeText(Add_Activity.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Add_Activity.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

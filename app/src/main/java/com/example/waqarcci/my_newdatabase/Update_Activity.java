package com.example.waqarcci.my_newdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {

    Button btUpadted ;
    EditText name, phone, email;
     DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);

        databaseHelper = new DatabaseHelper (this);

        btUpadted = (Button) findViewById(R.id.btupdate_data);
        name = (EditText) findViewById(R.id.updateName);
        phone = (EditText) findViewById(R.id.updateNumber);
        email = (EditText) findViewById(R.id.updateEmail);

        btUpadted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = databaseHelper.insertData (name.getText().toString(),Integer.parseInt(phone.getText().toString()) ,email.getText().toString());
                if (result)
                {
                    Toast.makeText(Update_Activity.this, "data Updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Update_Activity.this, "data not Updated ", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}

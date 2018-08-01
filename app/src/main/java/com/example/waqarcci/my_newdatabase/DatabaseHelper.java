package com.example.waqarcci.my_newdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "School.db";
    private static final String TABLE_NAME = "class";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , MOBILE_NUMBER INTEGER ,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);


    }

    public boolean insertData(String name, int phone, String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", phone);
        contentValues.put("EMAIL", email);

        long result = sqLiteDatabase.insert("class", null, contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getData(String phone) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String query = "SELECT * FROM class WHERE MOBILE_NUMBER = '" + phone + "'   ";

        Cursor res = sqLiteDatabase.rawQuery(query, null);
        return res;


    }

    public void updateData(String name, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("EMAIL", email);

        db.update(TABLE_NAME, contentValues, "MOBILE_NUMBER ='" + phone + "'  ", null);
        db.close();


    }

    public boolean deleteData(String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"MOBILE_NUMBER ='" + phone +"'  ",null);
        db.close();
        return true;
    }


}

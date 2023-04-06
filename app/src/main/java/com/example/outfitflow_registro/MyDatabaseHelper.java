package com.example.outfitflow_registro;

import android.os.Bundle;

public class MyDatabaseHelper {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDatabaseHelper(this);
        database = dbHelper.getWritableDatabase();
    }

}

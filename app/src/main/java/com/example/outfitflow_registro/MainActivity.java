package com.example.outfitflow_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.outfitflow_registro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            String name = ((EditText) findViewById(R.id.name_text)).getText().toString();
            String email = ((EditText) findViewById(R.id.email_text)).getText().toString();
            String password = ((EditText) findViewById(R.id.password_text)).getText().toString();
            String confirm_password = ((EditText) findViewById(R.id.confirm_text)).getText().toString();

            ContentValues values = new ContentValues();
            values.put("nombre", name);
            values.put("email", email);
            values.put("password", password);
            values.put("confirm_password", confirm_password);

            database.insert("registro", null, values);

            Toast.makeText(MainActivity.this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();

        });

    }

}

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "outfit_flow.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL("CREATE TABLE registro (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, correo TEXT, contrasena TEXT, confirmar_contrasena Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}












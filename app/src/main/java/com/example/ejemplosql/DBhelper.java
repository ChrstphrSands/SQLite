package com.example.ejemplosql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final String TABLE_MEMBER = "miembros";
    public static final String MIEMBRO_ID = "_id";
    public static final String MIEMBRO_NOMBRE = "nombre";

    static final String db_name = "DBMIEMBRO";
    static final int db_version = 1;

    private static final String CREATE_TABLE = "create table "
        + TABLE_MEMBER + "(" + MIEMBRO_ID
        + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + MIEMBRO_NOMBRE + " TEXT NOT NULL);";


    public DBhelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        onCreate(db);
    }
}

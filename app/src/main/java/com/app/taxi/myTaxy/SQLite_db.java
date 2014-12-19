package com.app.taxi.myTaxy;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLite_db extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Lviv_street.db";
    private static final int DATABASE_VERSION = 1;
    public static final String UID = "_id";
    public static final String STREETS = "Lemberg_street";
    public static final String TABLE_NAME = "Streets_table";
    public static final String STREET_NAME = "street_name";



    //TODO Make it ! )
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + STREET_NAME + " VARCHAR(255));";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
            + TABLE_NAME;

    public SQLite_db(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w("LOG_TAG", "Обновление базы данных с версии " + oldVersion
                + " до версии " + newVersion + ", которое удалит все старые данные");
        // Удаляем предыдущую таблицу при апгрейде
        db.execSQL(SQL_DELETE_ENTRIES);
        // Создаём новый экземпляр таблицы
        onCreate(db);
    }
}

package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sewaMobil.db";
    private static final String TABLE_SEWA = "sewa";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_MOBIL = "mobil";
    private static final String COLUMN_LAMA = "lama";
    private static final String COLUMN_TOTAL = "total";
    private static final String COLUMN_UANG = "uang";
    private static final String COLUMN_KEMBALIAN = "kembalian";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SEWA_TABLE = "CREATE TABLE " + TABLE_SEWA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMA + " TEXT,"
                + COLUMN_MOBIL + " TEXT,"
                + COLUMN_LAMA + " INTEGER,"
                + COLUMN_TOTAL + " INTEGER,"
                + COLUMN_UANG + " INTEGER,"
                + COLUMN_KEMBALIAN + " INTEGER" + ")";
        db.execSQL(CREATE_SEWA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEWA);
        onCreate(db);
    }

    public void addSewa(String nama, String mobil, int lama, int total, int uang, int kembalian) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, nama);
        values.put(COLUMN_MOBIL, mobil);
        values.put(COLUMN_LAMA, lama);
        values.put(COLUMN_TOTAL, total);
        values.put(COLUMN_UANG, uang);
        values.put(COLUMN_KEMBALIAN, kembalian);
        db.insert(TABLE_SEWA, null, values);
        db.close();
    }

    public Cursor getLastSewa() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_SEWA + " ORDER BY " + COLUMN_ID + " DESC LIMIT 1", null);
    }
}

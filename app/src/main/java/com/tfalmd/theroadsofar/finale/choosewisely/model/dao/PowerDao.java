package com.tfalmd.theroadsofar.finale.choosewisely.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tfalmd.theroadsofar.finale.choosewisely.model.Power;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tfalmd on 24/06/15.
 */
public class PowerDao extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "choosev1";
    private static final int DATABASE_VERSION = 1;

    public PowerDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE powers (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, advantage TEXT, disadvantage TEXT," +
                " utility INT, imageFile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS powers");
        onCreate(db);
    }

    public void create(Power p) {
        ContentValues values = new ContentValues();
        values.put("name", p.getName());
        values.put("advantage", p.getAdvantage());
        values.put("disadvantage", p.getDisadvantage());
        values.put("utility", p.getUtility());
        values.put("imageFile", p.getImageFile());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("powers", null, values);

        db.close();
    }

    public List<Power> all() {
        List<Power> result = new ArrayList<Power>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM powers", null);

        if (cursor.moveToFirst()) {
            do {
                result.add(new Power(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getInt(4), cursor.getString(5)));
            } while (cursor.moveToNext());
        }

        db.close();
        return result;
    }

    public int count() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM powers", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        db.close();
        return count;
    }

    public Power find(int id) {
        Power result = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("powers", new String[]{"id, advantage", "disadvantage",
                        "utility", "imageFile"}, "id=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = new Power(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getInt(4), cursor.getString(5));
        }

        db.close();

        return result;
    }
}